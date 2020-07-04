/**
 * 表单验证
 * @param $form {object} 表单对象
 * @param data {object} 表单内容
 * @return {boolean} true/false
 */
let validate = function ($form, data) {
    if (EUtil.isBlank(data.username)) {
        showMsg($form, 'danger', '请输入用户名');
        return false;
    }
    if (EUtil.isBlank(data.password)) {
        showMsg($form, 'danger', '请输入密码');
        return false;
    }
    if (loginAttempts >= loginAttemptsVerificationCode && EUtil.isBlank(data.code)) {
        showMsg($form, 'danger', '请输入验证码');
        return false;
    }
    return true;
};