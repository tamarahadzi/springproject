<userpage>

    <div class="container-div">
        <h3>{ title }</h3>

        <label class="label" for="dateFrom">From:</label>
        <input type="date" class="form-control" id="dateFrom" onchange="{opts.serviceClass.checkFreeCars}">

        <label class="label" for="dateTo">To:</label>
        <input type="date" class="form-control" id="dateTo" onchange="{opts.serviceClass.checkFreeCars}">

        <label class="label display-none" id="selectCarsLabel" for="selectCars">Available cars:</label>
        <select id="selectCars" class="form-control display-none" onchange="{opts.serviceClass.carDetails}">
            <option value="noCar">Choose car</option>
            <option each="{ car in cars }" value="{ car.id }">{ car.name }</option>
        </select>

        <table class="table display-none" id="carDetailsTable">
            <tr>
                <th>Name</th>
                <td>{ car1.name }</td>
            </tr>
            <tr>
                <th>Model</th>
                <td>{ car1.model }</td>
            </tr>
            <tr>
                <th>Gearbox</th>
                <td>{ car1.gearbox }</td>
            </tr>
            <tr>
                <th>Price</th>
                <td>{ car1.price }</td>
            </tr>
            <tr>
                <th>Year</th>
                <td>{ car1.year }</td>
            </tr>
            <tr>
                <th>Size</th>
                <td>{ car1.size }</td>
            </tr>

        </table>

        <button id="reserveButton" type="button" class="btn btn-primary display-none" onclick="{opts.serviceClass.reserveCar}">Reserve</button>
    </div>


    <script>
        try {
            if (opts.serviceClass !== undefined && opts.serviceClass !== null) {
                opts.serviceClass.userPage(this, opts);
            }
        } catch(error) {
            console.error("USER PAGE ERROR", error.message);
        }
    </script>

</userpage>