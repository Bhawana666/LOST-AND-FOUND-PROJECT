window.onload = function () {

    var home = document.getElementById("homeBtn-active");
    var login = document.getElementById("loginBtn");
    var lost = document.getElementById("lostBtn");
    var found = document.getElementById("foundBtn");
    var search = document.getElementById("SearchBtn");
    var viewitem = document.getElementById("view-btn");
    if(home){
      home.onclick = function(){
          window.location.href = "/Home";
      };
    }

     if(login){
       login.onclick = function(){
          window.location.href = "/login";
       };
     }

     if(lost){
       lost.onclick = function(){
          window.location.href = "/lostform";
       };
     }

     if(found){
      found.onclick = function(){
         window.location.href = "/foundform";
      };
    }
     if(search){
      search.onclick = function(){
         window.location.href = "/search";
      };
     }
     if(viewitem){
           viewitem.onclick = function(){
              window.location.href = "/ViewItem";
      };
     }
     //image preview
     var fileInput = document.querySelector('input[type="file"]');
     var preview = document.getElementById("preview");

     if (fileInput) {
         fileInput.addEventListener("change", function (event) {

             var file = event.target.files[0];

             if (file) {
                 preview.src = URL.createObjectURL(file);
                 preview.style.display = "block";
             }
         });
     }
};