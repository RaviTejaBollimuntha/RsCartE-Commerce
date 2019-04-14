$(document).ready(function(){
	var total = document.getElementById("total").value;
	var pageno = document.getElementById("pageno").value;
	var search = document.getElementById("search").value;
$('.demo4_top,.demo4_bottom').bootpag({
    total: total,
    page: pageno,
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
    aTag.setAttribute('href',"http://localhost:9444/?page="+num+"&search="+search);
   mytag.appendChild(aTag).click();
}); 
  
});
