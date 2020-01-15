function AdminPageRiot() {

    var thisClass = this;

    var viewObj = {
        cars: undefined
    };

    this.init = function () {
        this._adminPage();
    };

    this._adminPage = function () {
        riot.mount('adminpage', {
            title: "Admin page",
            serviceClass: thisClass
        })
    };

    this.adminPage = function (viewObject, mountOptions) {
        viewObj = viewObject;
        viewObj.title = mountOptions.title;
        viewObj.cars = [];
        jQuery.ajax({
            type: "GET",
            url: "/api/car",
            success: function (response) {
                if (response !== undefined && response !== []) {
                    viewObj.cars = response;
                    viewObj.update();
                }
            },
            error: function () {
                console.error("error - this.adminPage");
            }
        });
    };

    this.openAddCarDialog = function () {
        $("#addCarDialog").modal('show');
    };

    this.addCar = function () {
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
            success: function (response) {
                console.info("response", response);
                viewObj.cars = response;
                viewObj.update();
                $("#addCarDialog").modal('hide');
            },
            error: {}
        });
    };

    this.openDeleteCarDialog = function (event) {
        $("#deleteCarId").val(event.item.car.id);
        $("#deleteCarDialog").modal('show');
    };

    this.deleteCar = function () {
        $.ajax({
            type: "DELETE",
            url: "/api/car/" + $("#deleteCarId").val(),
            data: {},
            success: function (response) {
                console.info("response", response);
                viewObj.cars = response;
                viewObj.update();
                $("#deleteCarDialog").modal('hide');
            },
            error: {}
        });
    };

}