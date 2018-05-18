$(document).ready(function($) {

    $(".productQuantity").on("change",function() {
        var This = $(this);
        var quantity = $(this).val();
        var idProduct = $(this).attr("data-id");
        $.ajax({
            url: "/cart/update",
            type: "get",
            data: {
                quantity: quantity,
                id: idProduct
            },
            success: function(data) {
                var price = (parseFloat(data) * quantity).toFixed(1);
                This.closest("tr").find(".total").html("$" + price);

                var totalPrice = $(".total").text();
                var totalPriceNew = totalPrice.split("$");
                var total = 0;
                for(var i=1;i<totalPriceNew.length;i++) {
                    total = total + parseFloat(totalPriceNew[i]);
                }
                $("#totalPrice").text("$ " + total.toFixed(1));
            }
        });
    });

    $("body").on("click",".paginate", function(e) {
        e.preventDefault();
        var This = $(this);
        var page = $(this).text();
        $.ajax({
            url: "/api/getProductLimit",
            type: "GET",
            data: {
                page: page
            },
            async:true,
            success:function(data) {
                $(".pagination").find("li").removeClass("active");
                This.parent("li").addClass("active");

                $("body").find("table").find("tbody").empty();
                $("body").find("table").find("tbody").append(data);
            }
        })
    });

    var imageName = "";
    $("#image").change(function(e) {
        var listFile = e.target.files;
        imageName = listFile[0].name;
        var form = new FormData();
        form.append("file",listFile[0]);
        $.ajax({
            url: "/api/upload",
            type:"POST",
            data:form,
            enctype:"multipart/form-data",
            contentType:false,
            processData:false,
            success:function(data) {
                console.log(data);
            }
        })
    });

    $("#addProduct").click(function(e) {
        e.preventDefault();
        // gio co 2 cach de lay value
        // c1: Thu cong: lay theo id => .val()
        // C2: su dung serizable trong jquery de lay key value => su dung jackson trong apicontroller de mapping cho nhanh
        var formdata = $("form").serializeArray();
        var json = {};
        $.each(formdata, function(i, field) {
            if(field.value != "") {
                json[field.name] = field.value;
            }
        });
        json["image"] = imageName;

        $.ajax({
            url: "/api/addProduct",
            type: "POST",
            data: {
                jsonData : JSON.stringify(json)
            },
            success:function(data) {
                console.log(data);
            }
        });
    });
    var idProduct = 0;
    $("body").on("click",".editProduct", function(e) {
        e.preventDefault();
        idProduct = $(this).attr("data-id");

        $.ajax({
            url: "/api/getProductById",
            type:"GET",
            data:{
                id : idProduct
            },
            success: function(data) {
                $("#typeProduct").val(data.typeProductEntity.id);
                $("#name").val(data.name);
                $("#unitPrice").val(data.unitPrice);
                $("#promotionPrice").val(data.promotionPrice);
                $("#unit").val(data.unit);
                if(data.news == "1") {
                    $("#new").prop("checked", true);
                    $("#old").prop("checked", false);
                } else {
                    $("#new").prop("checked", false);
                    $("#old").prop("checked", true);
                }
                $("textarea[name='description']").text(data.description);
            }
        });

    });

    $("body").on("click","#updateProduct", function(e) {
       e.preventDefault();
       var json = {};
       var formData = $("form").serializeArray();
       $.each(formData, function(i, field) {
           json[field.name] = field.value;
       });

       json["id"] = idProduct;
       json["image"] = imageName;

       $.ajax({
           url: "/api/updateProduct",
           type: "POST",
           data:{
               jsonData: JSON.stringify(json)
           },
           success: function(data) {
               console.log(data);
           }
       });

    });


});