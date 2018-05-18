<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--header--%>
<c:import url="header.jsp"/>
<%--end header--%>

<%--content--%>
<div class="rev-slider">
    <div class="fullwidthbanner-container">
        <div class="fullwidthbanner">
            <div class="bannercontainer" >
                <div class="banner" >
                    <ul>
                        <!-- THE FIRST SLIDE -->
                        <li data-transition="boxfade" data-slotamount="20" class="active-revslide" style="width: 100%; height: 100%; overflow: hidden; z-index: 18; visibility: hidden; opacity: 0;">
                            <div class="slotholder" style="width:100%;height:100%;" data-duration="undefined" data-zoomstart="undefined" data-zoomend="undefined" data-rotationstart="undefined" data-rotationend="undefined" data-ease="undefined" data-bgpositionend="undefined" data-bgposition="undefined" data-kenburns="undefined" data-easeme="undefined" data-bgfit="undefined" data-bgfitend="undefined" data-owidth="undefined" data-oheight="undefined">
                                <div class="tp-bgimg defaultimg" data-lazyload="undefined" data-bgfit="cover" data-bgposition="center center" data-bgrepeat="no-repeat" data-lazydone="undefined" src="<c:url value='/resources/assets/dest/images/thumbs/1.jpg'/>" data-src="<c:url value='/resources/assets/dest/images/thumbs/1.jpg'/>" style="background-color: rgba(0, 0, 0, 0); background-repeat: no-repeat; background-image: url('<c:url value='/resources/assets/dest/images/thumbs/1.jpg'/>'); background-size: cover; background-position: center center; width: 100%; height: 100%; opacity: 1; visibility: inherit;">
                                </div>
                            </div>

                        </li>
                        <li data-transition="boxfade" data-slotamount="20" class="active-revslide" style="width: 100%; height: 100%; overflow: hidden; z-index: 18; visibility: hidden; opacity: 0;">
                            <div class="slotholder" style="width:100%;height:100%;" data-duration="undefined" data-zoomstart="undefined" data-zoomend="undefined" data-rotationstart="undefined" data-rotationend="undefined" data-ease="undefined" data-bgpositionend="undefined" data-bgposition="undefined" data-kenburns="undefined" data-easeme="undefined" data-bgfit="undefined" data-bgfitend="undefined" data-owidth="undefined" data-oheight="undefined">
                                <div class="tp-bgimg defaultimg" data-lazyload="undefined" data-bgfit="cover" data-bgposition="center center" data-bgrepeat="no-repeat" data-lazydone="undefined" src="<c:url value='/resources/assets/dest/images/thumbs/1.jpg'/>" data-src="<c:url value='/resources/assets/dest/images/thumbs/1.jpg'/>" style="background-color: rgba(0, 0, 0, 0); background-repeat: no-repeat; background-image: url('<c:url value='/resources/assets/dest/images/thumbs/1.jpg'/>'); background-size: cover; background-position: center center; width: 100%; height: 100%; opacity: 1; visibility: inherit;">
                                </div>
                            </div>

                        <li data-transition="boxfade" data-slotamount="20" class="active-revslide" style="width: 100%; height: 100%; overflow: hidden; z-index: 18; visibility: hidden; opacity: 0;">
                            <div class="slotholder" style="width:100%;height:100%;" data-duration="undefined" data-zoomstart="undefined" data-zoomend="undefined" data-rotationstart="undefined" data-rotationend="undefined" data-ease="undefined" data-bgpositionend="undefined" data-bgposition="undefined" data-kenburns="undefined" data-easeme="undefined" data-bgfit="undefined" data-bgfitend="undefined" data-owidth="undefined" data-oheight="undefined">
                                <div class="tp-bgimg defaultimg" data-lazyload="undefined" data-bgfit="cover" data-bgposition="center center" data-bgrepeat="no-repeat" data-lazydone="undefined" src="<c:url value='/resources/assets/dest/images/thumbs/1.jpg'/>" data-src="<c:url value='/resources/assets/dest/images/thumbs/1.jpg'/>" style="background-color: rgba(0, 0, 0, 0); background-repeat: no-repeat; background-image: url('<c:url value='/resources/assets/dest/images/thumbs/1.jpg'/>'); background-size: cover; background-position: center center; width: 100%; height: 100%; opacity: 1; visibility: inherit;">
                                </div>
                            </div>

                        </li>

                        <li data-transition="boxfade" data-slotamount="20" class="active-revslide current-sr-slide-visible" style="width: 100%; height: 100%; overflow: hidden; visibility: inherit; opacity: 1; z-index: 20;">
                            <div class="slotholder" style="width:100%;height:100%;" data-duration="undefined" data-zoomstart="undefined" data-zoomend="undefined" data-rotationstart="undefined" data-rotationend="undefined" data-ease="undefined" data-bgpositionend="undefined" data-bgposition="undefined" data-kenburns="undefined" data-easeme="undefined" data-bgfit="undefined" data-bgfitend="undefined" data-owidth="undefined" data-oheight="undefined">
                                <div class="tp-bgimg defaultimg" data-lazyload="undefined" data-bgfit="cover" data-bgposition="center center" data-bgrepeat="no-repeat" data-lazydone="undefined" src="<c:url value='/resources/assets/dest/images/thumbs/1.jpg'/>" data-src="<c:url value='/resources/assets/dest/images/thumbs/1.jpg'/>" style="background-color: rgba(0, 0, 0, 0); background-repeat: no-repeat; background-image: url('<c:url value='/resources/assets/dest/images/thumbs/1.jpg'/>'); background-size: cover; background-position: center center; width: 100%; height: 100%; opacity: 1; visibility: inherit;">
                                </div>
                            </div>

                        </li>
                    </ul>
                </div>
            </div>

            <div class="tp-bannertimer"></div>
        </div>
    </div>
    <!--slider-->
</div>
<div class="container">
    <div id="content" class="space-top-none">
        <div class="main-content">
            <div class="space60">&nbsp;</div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="beta-products-list">
                        <h4>SẢN PHẨM MỚI</h4>
                        <div class="beta-products-details">
                            <p class="pull-left">${listNewProduct.size()} Sản Phẩm Được Tìm Thấy</p>
                            <div class="clearfix"></div>
                        </div>

                        <div class="row">
                            <c:forEach items="${listNewProduct}" var="newProduct">
                                <div class="col-sm-3">
                                <div class="single-item">
                                    <div class="single-item-header">
                                        <a href="<c:url value='/sanpham/${newProduct.getId()}/chitiet'/>"><img style="height:200px;" src="<c:url value='/resources/image/product/${newProduct.image}'/>" alt=""></a>
                                    </div>
                                    <div class="single-item-body">
                                        <p class="single-item-title">${newProduct.name}</p>
                                        <p class="single-item-price" style="height:50px;">
                                            <c:choose>
                                                <c:when test="${newProduct.getPromotionPrice() != 0}">
                                                    <span class="flash-del">$ ${newProduct.getUnitPrice()}</span><br>
                                                    <span class="flash-sale">$ ${newProduct.getPromotionPrice()}</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="flash-sale">$ ${newProduct.getUnitPrice()}</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </p>
                                    </div>
                                    <div class="single-item-caption">
                                        <a class="add-to-cart pull-left" href="/cart/${newProduct.getId()}"><i class="fa fa-shopping-cart"></i></a>
                                        <a class="beta-btn primary" href="<c:url value='/sanpham/${newProduct.getId()}/chitiet'/>">Details <i class="fa fa-chevron-right"></i></a>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>

                        </div>
                    </div> <!-- .beta-products-list -->

                    <div class="space50">&nbsp;</div>

                    <div class="beta-products-list">
                        <h4>SẢN PHẨM KHUYẾN MÃI</h4>
                        <div class="beta-products-details">
                            <p class="pull-left">${listSaleProduct.size()} Sản Phẩm Được Tìm Thấy</p>
                            <div class="clearfix"></div>
                        </div>
                        <div class="row">
                            <c:forEach items="${listSaleProduct}" var="saleProduct">
                                <div class="col-sm-3" style="margin-top:10px;">
                                    <div class="single-item">
                                        <div class="single-item-header">
                                            <a href="<c:url value='/sanpham/${saleProduct.getId()}/chitiet'/>"><img style="height:200px;" src="<c:url value='/resources/image/product/${saleProduct.image}'/>" alt=""></a>
                                        </div>
                                        <div class="single-item-body">
                                            <p class="single-item-title">${saleProduct.name}</p>
                                            <p class="single-item-price" style="height:50px;">
                                                <c:choose>
                                                    <c:when test="${saleProduct.getPromotionPrice() != 0}">
                                                        <span class="flash-del">$ ${saleProduct.getUnitPrice()}</span><br>
                                                        <span class="flash-sale">$ ${saleProduct.getPromotionPrice()}</span>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <span class="flash-sale">$ ${saleProduct.getUnitPrice()}</span>
                                                    </c:otherwise>
                                                </c:choose>
                                            </p>
                                        </div>
                                        <div class="single-item-caption">
                                            <a class="add-to-cart pull-left" href="shopping_cart.html"><i class="fa fa-shopping-cart"></i></a>
                                            <a class="beta-btn primary" href="<c:url value='/sanpham/${saleProduct.getId()}/chitiet'/>">Details <i class="fa fa-chevron-right"></i></a>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>


                        </div>
                    </div> <!-- .beta-products-list -->
                </div>
            </div> <!-- end section with sidebar and main content -->


        </div> <!-- .main-content -->
    </div> <!-- #content -->
</div> <!-- .container -->
<%--end content--%>

<%--footer--%>
<c:import url="footer.jsp"/>