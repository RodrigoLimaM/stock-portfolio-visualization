function appendRow() {
    let input = document.createElement('input');
    input.className = 'form-control text-center';
    input.name = 'stock';
    input.type = 'text';
    let rowItemElementDiv = document.createElement("div");
    rowItemElementDiv.className = 'stock-info-row-item';
    rowItemElementDiv.appendChild(input);
    let firstRow = document.getElementById('first-row');
    firstRow.appendChild(rowItemElementDiv);
}