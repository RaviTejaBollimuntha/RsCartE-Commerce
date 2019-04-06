$(document).ready(function(){
	var total = document.getElementById("total").value;
$('.demo4_top,.demo4_bottom').bootpag({
    total: total,
    page: 1,
    maxVisible: 10,
    leaps: true,
    firstLastUse: true,
    first: 'First',
    last: 'Last',
    wrapClass: 'pagination',
    activeClass: 'active',
    disabledClass: 'disabled',
    nextClass: 'next',
    prevClass: 'prev',
    lastClass: 'last',
    firstClass: 'first'
}).on("page", function(event, num){
	var mytag=document.getElementById('page');
    var aTag = document.createElement('a');
    aTag.setAttribute('href',"http://localhost:9444/?page="+num);
   mytag.appendChild(aTag).click();
}); 
  
});
