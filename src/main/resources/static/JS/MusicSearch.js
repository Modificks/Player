document.getElementById('searchInput').addEventListener('input', function() {

    let input = document.getElementById('searchInput'),
        filter = input.value.toUpperCase(),
        tables = document.querySelectorAll('.list-of-songs');

    tables.forEach(function(table) {
        let tr = table.getElementsByTagName('tr');

        for (let i = 1; i < tr.length; i++) {
            let td = tr[i].getElementsByTagName('th');
            let rowVisible = false;

            for (let j = 0; j < td.length; j++) {
                if (td[j]) {
                    let txtValue = td[j].textContent || td[j].innerText;

                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        rowVisible = true;
                        break;
                    }
                }
            }

            if (rowVisible) {
                tr[i].style.display = '';
            } else {
                tr[i].style.display = 'none';
            }
        }
    });
});