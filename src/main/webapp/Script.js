window.onload = function () {

    var home = document.getElementById("homeBtn-active");
    var login = document.getElementById("loginBtn");
    var lost = document.getElementById("lostBtn");
    var found = document.getElementById("foundBtn");
    var search = document.getElementById("SearchBtn");
    var viewitem = document.getElementById("view-btn");
    if(home){
      home.onclick = function(){
          window.location.href = "/backend/Home";
      };
    }

     if(login){
       login.onclick = function(){
          window.location.href = "/backend/login";
       };
     }

     if(lost){
       lost.onclick = function(){
          window.location.href = "/backend/lostfrom";
       };
     }

     if(found){
      found.onclick = function(){
         window.location.href = "/backend/foundform";
      };
    }
     if(search){
      search.onclick = function(){
         window.location.href = "/backend/search";
      };
     }
     if(viewitem){
           viewitem.onclick = function(){
              window.location.href = "/backend/ViewItem";
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