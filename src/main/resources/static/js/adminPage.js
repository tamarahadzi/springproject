function AdminPage() {

    this.init = function () {
        var adminPageRiot = new AdminPageRiot();
        adminPageRiot.init();
    };

    /*$("#addCarDialogButton").on("click", function () {
        console.info("open car dialog");

        $("#addCarDialog").modal('show');
    });

    $("#addCar").on("click", function () {
        console.info("add car");

        $.ajax({
            type: "POST",
            url: "/api/car",
            data: {
                name:  $("#addCarName").val(),
                model: $("#addCarModel").val(),
                gearbox: $("#addCarGearbox").val(),
                price: $("#addCarPrice").val(),
                year: $("#addCarYear").val(),
                size: $("#addCarSize").val()
            },
            success: {},
            error: {}
        });

        $("#addCarDialog").modal('show');
    });

    $("#freeCarsButton").on("click", function () {
        console.info("free cars");

        $.ajax({
            type: "POST",
            url: "/api/freecars",
            data: {
                name:  $("#addCarName").val(),
                model: $("#addCarModel").val(),
                gearbox: $("#addCarGearbox").val(),
                price: $("#addCarPrice").val(),
                year: $("#addCarYear").val(),
                size: $("#addCarSize").val()
            },
            success: function () {
                $("#addCarDialog").modal('hide');
            },
            error: {}
        });

    });*/

}