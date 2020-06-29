var itemName = document.getElementsByClassName("itemName");
var amount = document.getElementsByClassName("amount");
var color = ["#0000FF", "#000080","#008080","#008000","#00FF00","#00FFFF","#FFFF00","#FF0000","#FF00FF","#808000","#800080","#800000","#BAD3FF","#5507FF","#CBFFD3","#00FF3B","#FFFF88","#FFBEDA","#FFBBFF","#E4FF8D","#BA55D3","	#A0522D"];

/*console.log ( itemName[0].textContent );
console.log ( Number(amount[0].textContent) );*/

nameArray = [];
amountArray = [];
colorArray = [];

for(var i = 0; i < itemName.length; i++){

	nameArray.push(itemName[i].textContent)
};

for(var i = 0; i < amount.length; i++){

	amountArray.push(Number(amount[i].textContent))
};

for(var i = 0; i < itemName.length; i++){

	colorArray.push(color[i])
};

console.log (amountArray);

var ctx = document.getElementById("myPieChartForDairy");
var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: nameArray,
    datasets: [{
        backgroundColor: colorArray,
        data: amountArray
    }]
  },
  options: {
    title: {
      display: true,
      text: '日の支出の割合',
      fontSize: 30
    }
  }
});