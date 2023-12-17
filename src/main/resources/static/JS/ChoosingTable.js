let currentTable = null;

function choosingTable(tableId) {

    let table = document.getElementById(tableId);

    if (currentTable !== table && currentTable !== null) {
        currentTable.style.display = 'none';
    }

    if (table.style.display === 'none') {
        table.style.display = 'block';
        currentTable = table;
    } else {
        table.style.display = 'none';
        currentTable = null;
    }
}