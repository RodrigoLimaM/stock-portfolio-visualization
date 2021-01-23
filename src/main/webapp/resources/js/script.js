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
    inputStock.required = true;

    let labelStockValue = document.createElement('label');
    labelStockValue.textContent = 'Stock Purchase Value';
    labelStockValue.className = 'col-sm-auto'

    let inputStockPurchaseValue = document.createElement('input');
    inputStockPurchaseValue.className = 'form-control text-center';
    inputStockPurchaseValue.name = 'stockPurchaseValue';
    inputStockPurchaseValue.type = 'number';
    inputStockPurchaseValue.step = '0.01';
    inputStockPurchaseValue.placeholder = 'ex: 10,98';
    inputStockPurchaseValue.required = true;

    inputStockPurchaseValue.addEventListener('keyup', function(){
        validateDecimalPlaces(this);
    })

    let labelQuantity = document.createElement('label');
    labelQuantity.textContent = 'Quantity';
    labelQuantity.className = 'col-sm-auto'

    let inputQuantity = document.createElement('input');
    inputQuantity.className = 'form-control text-center';
    inputQuantity.name = 'quantity';
    inputQuantity.type = 'number';
    inputQuantity.required = true;

    let labelFees = document.createElement('label');
    labelFees.textContent = 'Brokerage Fees';
    labelFees.className = 'col-sm-auto';

    let inputFees = document.createElement('input');
    inputFees.className = 'form-control text-center';
    inputFees.name = 'fees';
    inputFees.type = 'number';
    inputFees.step = '0.01';
    inputFees.placeholder = 'ex: 10,98';
    inputFees.required = true;

    inputFees.addEventListener('keyup', function(){
        validateDecimalPlaces(this);
    })

    let rowItemElementDiv = document.createElement("div");
    rowItemElementDiv.className = 'stock-info-row-item';

    rowItemElementDiv.appendChild(labelStock)
    rowItemElementDiv.appendChild(inputStock);
    rowItemElementDiv.appendChild(labelStockValue);
    rowItemElementDiv.appendChild(inputStockPurchaseValue);
    rowItemElementDiv.appendChild(labelQuantity)
    rowItemElementDiv.appendChild(inputQuantity);
    rowItemElementDiv.appendChild(labelFees);
    rowItemElementDiv.appendChild(inputFees);

    let stockInfoRow = document.getElementById('stock-info-row');
    stockInfoRow.appendChild(rowItemElementDiv);
}