package com.example.cidaasv2.Controller;

import android.content.Context;


import com.example.cidaasv2.Helper.Entity.LoginEntity;
import com.example.cidaasv2.Helper.Entity.PasswordlessEntity;
import com.example.cidaasv2.Helper.Enums.Result;
import com.example.cidaasv2.Helper.Extension.WebAuthError;
import com.example.cidaasv2.Helper.Genral.DBHelper;
import com.example.cidaasv2.Service.Entity.AccessToken.AccessTokenEntity;
import com.example.cidaasv2.Service.Entity.ClientInfo.ClientInfoEntity;
import com.example.cidaasv2.Service.Entity.Deduplication.RegisterDeduplication.RegisterDeduplicationEntity;
import com.example.cidaasv2.Service.Entity.LoginCredentialsEntity.LoginCredentialsResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.AuthenticateMFA.SmartPush.AuthenticateSmartPushResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.EnrollMFA.Email.EnrollEmailMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.EnrollMFA.Fingerprint.EnrollFingerprintMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.EnrollMFA.IVR.EnrollIVRMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.EnrollMFA.Pattern.EnrollPatternMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.EnrollMFA.SmartPush.EnrollSmartPushMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.EnrollMFA.TOTP.EnrollTOTPMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.InitiateMFA.Email.InitiateEmailMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.InitiateMFA.IVR.InitiateIVRMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.InitiateMFA.SMS.InitiateSMSMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.SetupMFA.BackupCode.SetupBackupCodeMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.SetupMFA.Email.SetupEmailMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.SetupMFA.IVR.SetupIVRMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.MFA.SetupMFA.SMS.SetupSMSMFAResponseEntity;
import com.example.cidaasv2.Service.Entity.ResetPassword.ResetNewPassword.ResetNewPasswordResponseEntity;
import com.example.cidaasv2.Service.Entity.ResetPassword.ResetNewPassword.ResetPasswordEntity;
import com.example.cidaasv2.Service.Entity.ResetPassword.ResetPasswordValidateCode.ResetPasswordValidateCodeResponseEntity;
import com.example.cidaasv2.Service.Entity.TenantInfo.TenantInfoEntity;
import com.example.cidaasv2.Service.Entity.UserinfoEntity;
import com.example.cidaasv2.Service.Register.RegisterUser.RegisterNewUserResponseEntity;
import com.example.cidaasv2.Service.Register.RegisterUserAccountVerification.RegisterUserAccountVerifyResponseEntity;
import com.example.cidaasv2.Service.Register.RegistrationSetup.RegistrationSetupResponseEntity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.Dictionary;
import java.util.HashMap;

import widas.raja.cidaasconsentv2.data.Entity.v1.ConsentEntity;

@RunWith(RobolectricTestRunner.class)
public class CidaasTest {

    Context context;

    Cidaas cidaas;

    @Before
    public void setUp() {

        context = RuntimeEnvironment.application;
        DBHelper.setConfig(context);
        cidaas = new Cidaas(context);


    }

    @Test
    public void testGetInstance() throws Exception {

        Cidaas result = Cidaas.getInstance(context);

        Assert.assertTrue(result instanceof Cidaas);

    }

    @Test
    public void testGetTenantInfo() throws Exception {


        cidaas = Cidaas.getInstance(context);

        cidaas.getTenantInfo(new Result<TenantInfoEntity>() {
            @Override
            public void success(TenantInfoEntity result) {
                Assert.assertEquals("Tenant Name", result.getData().getTenant_name());
            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testGetFailTenantInfo() throws Exception {


        cidaas = Cidaas.getInstance(context);

        cidaas.getTenantInfo(new Result<TenantInfoEntity>() {
            @Override
            public void success(TenantInfoEntity result) {
                Assert.assertEquals("Tenant Name", result.getData().getTenant_name());
            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testGetClientInfo() throws Exception {
        cidaas.getClientInfo("RequestId", new Result<ClientInfoEntity>() {
            @Override
            public void success(ClientInfoEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }


    @Test
    public void testIsENABLE_PKCE() throws Exception {
        boolean result = cidaas.isENABLE_PKCE();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testSetENABLE_PKCE() throws Exception {
        cidaas.setENABLE_PKCE(true);
    }

    @Test
    public void testSetFCMToken() throws Exception {
        cidaas.setFCMToken("FCMToken");
    }

    @Test
    public void testSetremoteMessage() throws Exception {
        Cidaas.validateDevice(new HashMap<String, String>() {{
            put("usage_pass", "usage_pass");
        }});
    }

    @Test
    public void testGetremoteMessage() throws Exception {
        Cidaas.validateDevice(new HashMap<String, String>() {{
            put("usage_pass", "usage_pass");
        }});

        Assert.assertEquals("usage_pass", cidaas.getInstanceId());
    }

    @Test
    public void testGetremoteMessageNull() throws Exception {
        Assert.assertEquals(null, cidaas.getInstanceId());
    }


    @Test
    public void testGetRequestId() throws Exception {

        cidaas.getRequestId("DomainUrl", "ClientId", "RedirectURL", "ClientSecret", null);
    }

    @Test
    public void testGetRequestId2() throws Exception {

        cidaas.getRequestId(null);
    }


    @Test
    public void testLoginWithCredentials() throws Exception {

        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setPassword("Password");
        loginEntity.setUsername("Username");
        loginEntity.setUsername_type("UsernameType");

        cidaas.loginWithCredentials("requestId", loginEntity, new Result<LoginCredentialsResponseEntity>() {
            @Override
            public void success(LoginCredentialsResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testGetMFAList() throws Exception {

        cidaas.getMFAList("sub", null);
    }

    @Test
    public void testConfigureEmail() throws Exception {

        cidaas.configureEmail("sub", new Result<SetupEmailMFAResponseEntity>() {
            @Override
            public void success(SetupEmailMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testEnrollEmail() throws Exception {

        cidaas.enrollEmail("code", "statusId", new Result<EnrollEmailMFAResponseEntity>() {
            @Override
            public void success(EnrollEmailMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testLoginWithEmail() throws Exception {

        cidaas.loginWithEmail(new PasswordlessEntity(), new Result<InitiateEmailMFAResponseEntity>() {
            @Override
            public void success(InitiateEmailMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testVerifyEmail() throws Exception {

        cidaas.verifyEmail("code", "statusId", null);
    }

    @Test
    public void testConfigureSMS() throws Exception {

        cidaas.configureSMS("sub", new Result<SetupSMSMFAResponseEntity>() {
            @Override
            public void success(SetupSMSMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testEnrollSMS() throws Exception {

        cidaas.enrollSMS("code", "statusId", null);
    }

    @Test
    public void testLoginWithSMS() throws Exception {

        cidaas.loginWithSMS(new PasswordlessEntity(), new Result<InitiateSMSMFAResponseEntity>() {
            @Override
            public void success(InitiateSMSMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testVerifySMS() throws Exception {

        cidaas.verifySMS("code", "statusId", new Result<LoginCredentialsResponseEntity>() {
            @Override
            public void success(LoginCredentialsResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testConfigureIVR() throws Exception {

        cidaas.configureIVR("sub", new Result<SetupIVRMFAResponseEntity>() {
            @Override
            public void success(SetupIVRMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testEnrollIVR() throws Exception {

        cidaas.enrollIVR("code", "statusId", new Result<EnrollIVRMFAResponseEntity>() {
            @Override
            public void success(EnrollIVRMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testLoginWithIVR() throws Exception {
        cidaas.loginWithIVR(new PasswordlessEntity(), new Result<InitiateIVRMFAResponseEntity>() {
            @Override
            public void success(InitiateIVRMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testVerifyIVR() throws Exception {

        cidaas.verifyIVR("code", "statusId", new Result<LoginCredentialsResponseEntity>() {
            @Override
            public void success(LoginCredentialsResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testConfigureBackupcode() throws Exception {

        cidaas.configureBackupcode("sub", new Result<SetupBackupCodeMFAResponseEntity>() {
            @Override
            public void success(SetupBackupCodeMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testLoginWithBackupcode() throws Exception {

        cidaas.loginWithBackupcode("code", new PasswordlessEntity(), new Result<LoginCredentialsResponseEntity>() {
            @Override
            public void success(LoginCredentialsResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testConfigurePatternRecognition() throws Exception {

        cidaas.configurePatternRecognition("pattern", "sub", "", new Result<EnrollPatternMFAResponseEntity>() {
            @Override
            public void success(EnrollPatternMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testLoginWithPatternRecognition() throws Exception {

        cidaas.loginWithPatternRecognition("pattern", new PasswordlessEntity(), new Result<LoginCredentialsResponseEntity>() {
            @Override
            public void success(LoginCredentialsResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testVerifyPattern() throws Exception {

        cidaas.verifyPattern("patternString", "statusId", null);
    }

    @Test
    public void testConfigureFaceRecognition() throws Exception {

/*        cidaas.configureFaceRecognition(new File(getClass().getResource("/com/example/cidaasv2/Controller/PleaseReplaceMeWithTestFile.txt").getFile()), "sub", new Result<EnrollFaceMFAResponseEntity>() {
            @Override
            public void success(EnrollFaceMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });*/
    }

    @Test
    public void testLoginWithFaceRecognition() throws Exception {

/*        cidaas.loginWithFaceRecognition(new File(getClass().getResource("/com/example/cidaasv2/Controller/PleaseReplaceMeWithTestFile.txt").getFile()), new PasswordlessEntity(), new Result<LoginCredentialsResponseEntity>() {
            @Override
            public void success(LoginCredentialsResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });*/
    }

    @Test
    public void testVerifyFace() throws Exception {

        //cidaas.verifyFace(null,"statusId", null);
    }

    @Test
    public void testConfigureFingerprint() throws Exception {

        cidaas.configureFingerprint(context, "", "", null, new Result<EnrollFingerprintMFAResponseEntity>() {
            @Override
            public void success(EnrollFingerprintMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testLoginWithFingerprint() throws Exception {

        cidaas.loginWithFingerprint(context, new PasswordlessEntity(), null, new Result<LoginCredentialsResponseEntity>() {
            @Override
            public void success(LoginCredentialsResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testVerifyFingerprint() throws Exception {
        cidaas.verifyFingerprint(context, "statusId", null, null);
    }

    @Test
    public void testConfigureSmartPush() throws Exception {

        cidaas.configureSmartPush("sub", "", new Result<EnrollSmartPushMFAResponseEntity>() {
            @Override
            public void success(EnrollSmartPushMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testLoginWithSmartPush() throws Exception {

        cidaas.loginWithSmartPush(new PasswordlessEntity(), new Result<LoginCredentialsResponseEntity>() {
            @Override
            public void success(LoginCredentialsResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testVerifySmartPush() throws Exception {

        cidaas.verifySmartPush("randomNumber", "statusId", new Result<AuthenticateSmartPushResponseEntity>() {
            @Override
            public void success(AuthenticateSmartPushResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testConfigureTOTP() throws Exception {

        cidaas.configureTOTP("sub", "", new Result<EnrollTOTPMFAResponseEntity>() {
            @Override
            public void success(EnrollTOTPMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testLoginWithTOTP() throws Exception {

        cidaas.loginWithTOTP(new PasswordlessEntity(), new Result<LoginCredentialsResponseEntity>() {
            @Override
            public void success(LoginCredentialsResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testListenTOTP() throws Exception {
        cidaas.listenTOTP("sub");
    }

    @Test
    public void testCancelListenTOTP() throws Exception {
        cidaas.cancelListenTOTP();
    }

    @Test
    public void testConfigureVoiceRecognition() throws Exception {

/*        cidaas.configureVoiceRecognition(new File(getClass().getResource("/com/example/cidaasv2/Controller/PleaseReplaceMeWithTestFile.txt").getFile()), "sub", new Result<EnrollVoiceMFAResponseEntity>() {
            @Override
            public void success(EnrollVoiceMFAResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });*/
    }

    @Test
    public void testLoginWithVoiceRecognition() throws Exception {

       /* cidaas.loginWithVoiceRecognition(new File(getClass().getResource("/com/example/cidaasv2/Controller/PleaseReplaceMeWithTestFile.txt").getFile()), new PasswordlessEntity(), new Result<LoginCredentialsResponseEntity>() {
            @Override
            public void success(LoginCredentialsResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });*/
    }

    @Test
    public void testVerifyVoice() throws Exception {

        //  cidaas.verifyVoice(new File(getClass().getResource("/com/example/cidaasv2/Controller/PleaseReplaceMeWithTestFile.txt").getFile()), "statusId", null);
    }

    @Test
    public void testGetRegistrationFields() throws Exception {

        cidaas.getRegistrationFields("requestId", "locale", new Result<RegistrationSetupResponseEntity>() {
            @Override
            public void success(RegistrationSetupResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testRegisterUser() throws Exception {

        cidaas.registerUser("requestId", null, new Result<RegisterNewUserResponseEntity>() {
            @Override
            public void success(RegisterNewUserResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testInitiateEmailVerification() throws Exception {

        cidaas.initiateEmailVerification("sub", "requestId", null);
    }

    @Test
    public void testInitiateSMSVerification() throws Exception {

        cidaas.initiateSMSVerification("sub", "requestId", null);
    }

    @Test
    public void testInitiateIVRVerification() throws Exception {

        cidaas.initiateIVRVerification("sub", "requestId", null);
    }

    @Test
    public void testVerifyAccount() throws Exception {

        cidaas.verifyAccount("code", "accvid", new Result<RegisterUserAccountVerifyResponseEntity>() {
            @Override
            public void success(RegisterUserAccountVerifyResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testGetDeduplicationDetails() throws Exception {
        cidaas.getDeduplicationDetails("trackId", null);
    }

    @Test
    public void testRegisterUser2() throws Exception {

        cidaas.registerUser("trackId", new Result<RegisterDeduplicationEntity>() {
            @Override
            public void success(RegisterDeduplicationEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testLoginWithDeduplication() throws Exception {

        cidaas.loginWithDeduplication("requestId", "sub", "password", new Result<LoginCredentialsResponseEntity>() {
            @Override
            public void success(LoginCredentialsResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testInitiateResetPasswordByEmail() throws Exception {

        cidaas.initiateResetPasswordByEmail("requestId", "email", null);
    }

    @Test
    public void testInitiateResetPasswordBySMS() throws Exception {

        cidaas.initiateResetPasswordBySMS("requestId", "mobileNumber", null);
    }

    @Test
    public void testHandleResetPassword() throws Exception {

        cidaas.handleResetPassword("verificationCode", "rprq", new Result<ResetPasswordValidateCodeResponseEntity>() {
            @Override
            public void success(ResetPasswordValidateCodeResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testResetPassword() throws Exception {
        ResetPasswordEntity resetPasswordEntity = new ResetPasswordEntity();
        resetPasswordEntity.setConfirmPassword("Password");
        resetPasswordEntity.setPassword("Password");
        resetPasswordEntity.setExchangeId("ExchangeID");
        resetPasswordEntity.setResetRequestId("ResetRequestId");

        cidaas.resetPassword(resetPasswordEntity, new Result<ResetNewPasswordResponseEntity>() {
            @Override
            public void success(ResetNewPasswordResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testResetPasswordNull() throws Exception {
        ResetPasswordEntity resetPasswordEntity = new ResetPasswordEntity();
        resetPasswordEntity.setConfirmPassword("ConfirmPassword");
        resetPasswordEntity.setPassword("Password");
        resetPasswordEntity.setExchangeId("ExchangeID");
        resetPasswordEntity.setResetRequestId("ResetRequestId");

        cidaas.resetPassword(resetPasswordEntity, new Result<ResetNewPasswordResponseEntity>() {
            @Override
            public void success(ResetNewPasswordResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testResetPasswordCase2() throws Exception {
        ResetPasswordEntity resetPasswordEntity = new ResetPasswordEntity();
        resetPasswordEntity.setConfirmPassword("");
        resetPasswordEntity.setPassword("");
        resetPasswordEntity.setExchangeId("");
        resetPasswordEntity.setResetRequestId("");

        cidaas.resetPassword(resetPasswordEntity, new Result<ResetNewPasswordResponseEntity>() {
            @Override
            public void success(ResetNewPasswordResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }


    @Test
    public void testResetPasswordCase3() throws Exception {
        ResetPasswordEntity resetPasswordEntity = new ResetPasswordEntity();
        resetPasswordEntity.setConfirmPassword("Pass");
        resetPasswordEntity.setPassword("Pass");
        resetPasswordEntity.setExchangeId("");
        resetPasswordEntity.setResetRequestId("");

        cidaas.resetPassword(resetPasswordEntity, new Result<ResetNewPasswordResponseEntity>() {
            @Override
            public void success(ResetNewPasswordResponseEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }


    @Test
    public void testChangePassword() throws Exception {

        cidaas.changePassword("sub", null, null);
    }

    @Test
    public void testGetAccessToken() throws Exception {

        cidaas.getAccessToken("sub", new Result<AccessTokenEntity>() {
            @Override
            public void success(AccessTokenEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testGetUserInfo() throws Exception {

        cidaas.getUserInfo("userId", new Result<UserinfoEntity>() {
            @Override
            public void success(UserinfoEntity result) {

            }

            @Override
            public void failure(WebAuthError error) {

            }
        });
    }

    @Test
    public void testRenewToken() throws Exception {
        cidaas.renewToken("refershtoken", null);
    }


    @Test
    public void testLoginWithFIDO() throws Exception {
        cidaas.loginWithFIDO(null, null, null);
    }

    @Test
    public void testGetLoginURL3() throws Exception {

        cidaas.getLoginURL("DomainUrl", "ClientId", "RedirectURL", "ClientSecret", null);
    }
}