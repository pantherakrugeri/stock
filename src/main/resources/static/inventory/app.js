var inventoryStockApp = angular.module('inventoryStockApp', ['ui.grid', 'ui.grid.edit']);

inventoryStockApp.controller('InventoryStockController', function InventoryStockController($scope, $http) {
    var vm = this;

    vm.gridOptions = {
        enableSorting: true,
        enableGridMenu: true,
        columnDefs: [

            { field: 'stockId', enableCellEdit: false},
            { field: 'stockName' },
            { field: 'stockCode' },
            { field: 'stockCost' },
            { field: 'stockQty', type: 'number' }
        ]
    };

    $http.get('/getStock').
        then(function(response) {
            vm.gridOptions.data = response.data;
        });
});

