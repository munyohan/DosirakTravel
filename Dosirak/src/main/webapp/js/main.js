window.addEventListener("load", function(){
    var setTimer =0; 
    var result = 0;
    setTimer = setInterval(function(){
       result = Math.floor(Math.random() * 6) + 1;
       /* var p1 = document.getElementById("p1");
       p1.innerHTML = result; */
       var img1 = document.getElementById("frog1");
       var house1 = document.getElementById("house1");
       var house2 = document.getElementById("house2");
       var house3 = document.getElementById("house3");
       var house4 = document.getElementById("house4");
       var house5 = document.getElementById("house5");
       var house6 = document.getElementById("house6");
       house1.style.opacity = "0.5";
       house2.style.opacity = "0.5";
       house3.style.opacity = "0.5";
       house4.style.opacity = "0.5";
       house5.style.opacity = "0.5";
       house6.style.opacity = "0.5";
       img1.style.opacity = "1";
       if(result == 2){
          img1.src = "../images/개구리1.png";
          img1.style.position = "absolute";
          img1.style.top = "320px";
          img1.style.left = "830px";
          house2.style.opacity = "1";            
       }else if(result == 3){
          img1.src = "../images/개구리1.png";
          img1.style.position = "absolute";
          img1.style.top = "370px";
          img1.style.left = "1250px";
          house3.style.opacity = "1";
       }else if(result == 4){
          img1.src = "../images/개구리1.png";
          img1.style.position = "absolute";
          img1.style.top = "680px";
          img1.style.left = "520px";
          house4.style.opacity = "1";
       }else if(result == 5){
          img1.src = "../images/개구리1.png";
          img1.style.position = "absolute";
          img1.style.top = "570px";
          img1.style.left = "815px";
          house5.style.opacity = "1";
       }else if(result == 6){
          img1.src = "../images/개구리1.png";
          img1.style.position = "absolute";
          img1.style.top = "610px";
          img1.style.left = "1150px";
          house6.style.opacity = "1";
       }else{      
           img1.src = "../images/개구리1.png";
          img1.style.position = "absolute";
          img1.style.top = "320px";
          img1.style.left = "500px";

          house1.style.opacity = "1";
          
       }
       
       
    }, 3000);
 });


function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

function filterFunction() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    div = document.getElementById("myDropdown");
    a = div.getElementsByTagName("a");
    for (i = 0; i < a.length; i++) {
        if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
            a[i].style.display = "";
        } else {
            a[i].style.display = "none";
        }
	}
    
}