<userpage>

    <div>
        <h3>{ title }</h3>
        <button type="button" class="btn btn-primary" onclick="{opts.serviceClass.freeCars}">Free Cars</button>
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