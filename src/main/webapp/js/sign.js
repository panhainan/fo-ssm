/**
 * Created by fo on 2017/2/5.
 */
function signIn() {
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
            }else{
                location.href = "index.html"
            }
        }
    });
}