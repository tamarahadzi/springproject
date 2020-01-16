function Login () {

    this.init = function () {

        $("#registerDialogButton").on("click", function () {
            console.info("register");

            $("#registerDialog").modal('show');
        });

        $("#registerButton").on("click", function () {
            console.info("register click");

            $.ajax({
                type: "POST",
                url: "/api/user",
                data: {
                    firstName: $("#firstName").val(),
                    lastName: $("#lastName").val(),
                    email: $("#email").val(),
                    password: $("#password").val()
                },
                success: function () {
                    $("#registerDialog").modal('hide');
                },
                error: {}
            })
        });
    };
}