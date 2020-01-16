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

}