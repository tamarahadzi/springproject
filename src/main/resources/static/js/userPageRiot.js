function UserPageRiot() {

    var thisClass = this;

    var viewObj = {
        cars: undefined
    };

    this.init = function () {
        this._userPage();


    };

    this._userPage = function () {
        riot.mount('userpage', {
            title: "User page",
            serviceClass: thisClass
        })
    };

    this.userPage = function (viewObject, mountOptions) {
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
                console.error("error - this.userPage");
            }
        });
    };

    this.freeCars = function () {

    };

    this.checkFreeCars = function () {
        console.info("fromVal", $("#dateFrom").val());
        console.info("toVal", $("#dateTo").val());
        if($("#dateFrom").val() !== "" && $("#dateTo").val()) {
            jQuery.ajax({
                type: "GET",
                url: "/api/car",
                success: function (response) {
                    if (response !== undefined && response !== []) {
                        viewObj.cars = response;
                        viewObj.update();
                        $("#selectCarsLabel").removeClass("display-none");
                        $("#selectCars").removeClass("display-none");
                        $("#reserveButton").removeClass("display-none");
                        $("#selectCarsLabel").addClass("display-block");
                        $("#selectCars").addClass("display-block");
                        $("#reserveButton").addClass("display-block");
                    }
                },
                error: function () {
                    console.error("error - this.userPage");
                }
            });
        }
    };


}