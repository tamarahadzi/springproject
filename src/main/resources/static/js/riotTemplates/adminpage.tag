<adminpage>

    <div>
        <h3>{ title }</h3>
        <button type="button" class="btn btn-primary" onclick="{opts.serviceClass.openAddCarDialog}">Add Car</button>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Model</th>
                <th>Gearbox</th>
                <th>Price</th>
                <th>Year</th>
                <th>Size</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <tr each="{ car in cars }">
                <td class="group-td">{ car.name }</td>
                <td class="group-td">{ car.model }</td>
                <td class="group-td">{ car.gearbox }</td>
                <td class="group-td">{ car.price }</td>
                <td class="group-td">{ car.year }</td>
                <td class="group-td">{ car.size }</td>
                <td class="group-td">
                    <button class="btn btn-danger" onclick="{opts.serviceClass.openDeleteCarDialog}">Delete</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="modal" id="addCarDialog" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add Car</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <label for="addCarName">Name:</label>
                    <input id="addCarName" type="text" class="form-control" placeholder="Name"/>
                    <label for="addCarModel" class="label">Model:</label>
                    <input id="addCarModel" type="text" class="form-control" placeholder="Model"/>
                    <label for="addCarGearbox" class="label">Gearbox:</label>
                    <select id="addCarGearbox" class="form-control">
                        <option value="NoGearbox">Choose gearbox</option>
                        <option value="manual">Manual</option>
                        <option value="automatic">Automatic</option>
                    </select>
                    <label for="addCarPrice" class="label">Price:</label>
                    <input id="addCarPrice" type="text" class="form-control" placeholder="Price"/>
                    <label for="addCarYear" class="label">Year:</label>
                    <input id="addCarYear" type="text" class="form-control" placeholder="Year"/>
                    <label for="addCarSize" class="label">Size:</label>
                    <select id="addCarSize" class="form-control">
                        <option value="NoSize">Choose size</option>
                        <option value="small">Small</option>
                        <option value="medium">Medium</option>
                        <option value="large">Large</option>
                    </select>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="{opts.serviceClass.addCar}">Add</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="deleteCarDialog" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog group-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Delete Car</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <label>Are you sure you want to delete this car?</label>
                    <input type="hidden" id="deleteCarId" class="form-control">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" onclick="{opts.serviceClass.deleteCar}">Delete</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                </div>
            </div>
        </div>
    </div>

    <script>
        try {
            if (opts.serviceClass !== undefined && opts.serviceClass !== null) {
                opts.serviceClass.adminPage(this, opts);
            }
        } catch(error) {
            console.error("ADMIN PAGE ERROR", error.message);
        }
    </script>

</adminpage>