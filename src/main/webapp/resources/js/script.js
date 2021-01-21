function validateDecimalPlaces(inputStockValue) {
    inputStockValue.value = inputStockValue.value.replace(/(\.\d{2})\d+/g, '$1');
}

function appendRow() {

    let labelStock = document.createElement('label');
    labelStock.textContent = 'Stock Symbol';
    labelStock.className = 'col-sm-auto'

    let inputStock = document.createElement('input');
    inputStock.className = 'form-control text-center';
    inputStock.name = 'stock';
    inputStock.type = 'text';
    inputStock.maxLength = 6;
    inputStock.placeholder = 'ex: ITSA3';

    let labelStockValue = document.createElement('label');
    labelStockValue.textContent = 'Stock Value';
    labelStockValue.className = 'col-sm-auto'

    let inputStockValue = document.createElement('input');
    inputStockValue.className = 'form-control text-center';
    inputStockValue.name = 'stockValue';
    inputStockValue.type = 'number';
    inputStockValue.step = '0.01';
    inputStockValue.placeholder = 'ex: 10,98';

    inputStockValue.addEventListener('keyup', function(){
        validateDecimalPlaces(this);
    })

    let labelQuantity = document.createElement('label');
    labelQuantity.textContent = 'Quantity';
    labelQuantity.className = 'col-sm-auto'

    let inputQuantity = document.createElement('input');
    inputQuantity.className = 'form-control text-center';
    inputQuantity.name = 'quantity';
    inputQuantity.type = 'number';

    let labelFees = document.createElement('label');
    labelFees.textContent = 'Brokerage Fees';
    labelFees.className = 'col-sm-auto';

    let inputFees = document.createElement('input');
    inputFees.className = 'form-control text-center';
    inputFees.name = 'fees';
    inputFees.type = 'number';
    inputFees.step = '0.01';
    inputFees.placeholder = 'ex: 10,98';

    inputFees.addEventListener('keyup', function(){
        validateDecimalPlaces(this);
    })

    let rowItemElementDiv = document.createElement("div");
    rowItemElementDiv.className = 'stock-info-row-item';

    rowItemElementDiv.appendChild(labelStock)
    rowItemElementDiv.appendChild(inputStock);
    rowItemElementDiv.appendChild(labelStockValue);
    rowItemElementDiv.appendChild(inputStockValue);
    rowItemElementDiv.appendChild(labelQuantity)
    rowItemElementDiv.appendChild(inputQuantity);
    rowItemElementDiv.appendChild(labelFees);
    rowItemElementDiv.appendChild(inputFees);

    let stockInfoRow = document.getElementById('stock-info-row');
    stockInfoRow.appendChild(rowItemElementDiv);
}