/**
 * Created by fo on 2017/2/5.
 */
$(document).ready(function () {
    $('#signInForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            'userName': {
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: '长度必须在3-20之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '只能使用大小写字母、数字、下划线'
                    }
                }
            },
            userPass: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 16,
                        message: '长度必须在6-16之间'
                    }
                }
            }

        }
    }).on("success.form.bv", function (e) {
        e.preventDefault();
        var $form = $(e.target);
        var validator = $form.data('bootstrapValidator');
        var user = {
            userName: validator.getFieldElements('userName').val(),
            userPass: validator.getFieldElements('userPass').val()
        };
        console.info(user);
        $.ajax({
            type: "POST",
            url: "user/signIn",
            data: user,
            success: function (responseData) {
                console.log(responseData);
                if (!responseData.success) {
                    alert(responseData.errorMsg);
                } else {
                    //location.href = "index.html"
                }
            }
        });
    });
    ;
    /*$("#signInForm").submit(function(e) {
     e.preventDefault();
     var user = {
     userName: $("#inputAccount").val(),
     userPass: $("#inputPassword").val()
     };
     console.info(user);
     $.ajax({
     type: "POST",
     url: "user/signIn",
     data: user,
     success: function (responseData) {
     console.log(responseData);
     if (!responseData.success) {
     alert(responseData.errorMsg);
     } else {
     location.href = "index.html"
     }
     }
     });
     });*/
});
function checkAccount() {
    var userName = $("#inputAccount").val();
    $.ajax({
        type: "POST",
        url: "user/checkAccount",
        data: {"userName": userName},
        success: function (responseData) {
            console.log(responseData);
            if (responseData.success) {
                if (!responseData.data.exist) {
                    $("#accountDiv").addClass("has-success");
                    return true;
                } else {
                    $("#accountDiv").addClass("has-error");
                    return false;
                }
            }
        }
    });
    return false;
}
function checkEmail() {
    var userEmail = $("#inputEmail").val();
    $.ajax({
        type: "POST",
        url: "user/checkEmail",
        data: {"userEmail": userEmail},
        success: function (responseData) {
            console.log(responseData);
            if (responseData.success) {
                if (!responseData.data.exist) {
                    $("#emailDiv").addClass("has-success");
                    return true;
                } else {
                    $("#emailDiv").addClass("has-error");
                    return false;
                }
            }
        }
    });
    return false;
}
function signUp() {
    var user = {
        userName: $("#inputAccount").val(),
        userPass: $("#inputPassword").val(),
        userEmail: $("#inputEmail").val()
    };
    console.info(user);
    $.ajax({
        type: "POST",
        url: "user/signUp",
        data: user,
        success: function (responseData) {
            console.log(responseData);
            if (!responseData.success) {
                alert(responseData.errorMsg);
            } else {
                location.href = "sign-in.html"
            }
        }
    });
}