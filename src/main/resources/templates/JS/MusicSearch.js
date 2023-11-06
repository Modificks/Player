document.getElementById('searchInput').addEventListener('input', function() {

     let input = document.getElementById('searchInput'),
         filter = input.value.toUpperCase(),
         table = document.getElementsByClassName('list-of-songs')[0],
         tr = table.getElementsByTagName('tr');

    for (let i = 1; i < tr.length; i++) {
         let td = tr[i].getElementsByTagName('th');

        for (let j = 0; j < td.length; j++) {
            if (td[j]) {
                let txtValue = td[j].textContent || td[j].innerText;

                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = '';
                    break;
                } else {
                    tr[i].style.display = 'none';
                }
            }
        }
    }
});