function appendRow() {

    let labelStock = document.createElement('label');
    labelStock.textContent = 'Stock Symbol';
    labelStock.className = 'col-sm-auto'

    let inputStock = document.createElement('input');
    inputStock.className = 'form-control text-center';
    inputStock.name = 'stock';
    inputStock.type = 'text';

    let labelQuantity = document.createElement('label');
    labelQuantity.textContent = 'Quantity';
    labelQuantity.className = 'col-sm-auto'

    let inputQuantity = document.createElement('input');
    inputQuantity.className = 'form-control text-center';
    inputQuantity.name = 'quantity';
    inputQuantity.type = 'text';

    let labelFees = document.createElement('label');
    labelFees.textContent = 'Brokerage Fees';
    labelFees.className = 'col-sm-auto'

    let inputFees = document.createElement('input');
    inputFees.className = 'form-control text-center';
    inputFees.name = 'fees';
    inputFees.type = 'text';

    let rowItemElementDiv = document.createElement("div");
    rowItemElementDiv.className = 'stock-info-row-item';

    rowItemElementDiv.appendChild(labelStock)
    rowItemElementDiv.appendChild(inputStock);
    rowItemElementDiv.appendChild(labelQuantity)
    rowItemElementDiv.appendChild(inputQuantity);
    rowItemElementDiv.appendChild(labelFees);
    rowItemElementDiv.appendChild(inputFees);

    let firstRow = document.getElementById('first-row');
    firstRow.appendChild(rowItemElementDiv);
}