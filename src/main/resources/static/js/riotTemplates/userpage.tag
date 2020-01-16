<userpage>

    <div class="container-div">
        <h3>{ title }</h3>
        <button type="button" class="btn btn-primary" onclick="{opts.serviceClass.freeCars}">Free Cars</button>

        <label class="label" for="dateFrom">From:</label>
        <input type="date" class="form-control" id="dateFrom" onchange="{opts.serviceClass.checkFreeCars}">

        <label class="label" for="dateTo">To:</label>
        <input type="date" class="form-control" id="dateTo" onchange="{opts.serviceClass.checkFreeCars}">

        <label class="label" id="selectCarsLabel" for="selectCars" class="display-none">Available cars:</label>
        <select id="selectCars" class="form-control display-none">
            <option value="NoCar">Choose car</option>
            <option each="{ car in cars }" value="{ car.id }">{ car.name }</option>
        </select>

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