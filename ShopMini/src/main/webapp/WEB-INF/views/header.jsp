<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index </title>
    <link href='http://fonts.googleapis.com/css?family=Dosis:300,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value='/resources/assets/dest/css/font-awesome.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/assets/dest/vendors/colorbox/example3/colorbox.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/assets/dest/rs-plugin/css/settings.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/assets/dest/rs-plugin/css/responsive.css'/>">
    <link rel="stylesheet" title="style" href="<c:url value='/resources/assets/dest/css/style.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/assets/dest/css/animate.css'/>">
    <link rel="stylesheet" title="style" href="<c:url value='/resources/assets/dest/css/huong-style.css'/>">
</head>
<body>

<div id="header">
    <div class="header-top">
        <div class="container">
            <div class="pull-left auto-width-left">
                <ul class="top-menu menu-beta l-inline">
                    <li><a href=""><i class="fa fa-home"></i> 90-92 Lê Thị Riêng, Bến Thành, Quận 1</a></li>
                    <li><a href=""><i class="fa fa-phone"></i> 0163 296 7751</a></li>
                </ul>
            </div>
            <div class="pull-right auto-width-right">
                <ul class="top-details menu-beta l-inline">
                    <li><a href="#"><i class="fa fa-user"></i>Tài khoản</a></li>
                    <li><a href="#">Đăng kí</a></li>
                    <li><a href="#">Đăng nhập</a></li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div> <!-- .container -->
    </div> <!-- .header-top -->
    <div class="header-body">
        <div class="container beta-relative">
            <div class="pull-left">
                <a href="index.html" id="logo"><img src="<c:url value='/resources/assets/dest/images/logo-cake.png'/>" width="200px" alt=""></a>
            </div>
            <div class="pull-right beta-components space-left ov">
                <div class="space10">&nbsp;</div>
                <div class="beta-comp">
                    <form role="search" method="get" id="searchform" action="/">
                        <input type="text" value="" name="s" id="s" placeholder="Nhập từ khóa..." />
                        <button class="fa fa-search" type="submit" id="searchsubmit"></button>
                    </form>
                </div>

                <div class="beta-comp">
                    <div class="cart">
                        <div class="beta-select"><i class="fa fa-shopping-cart"></i> Giỏ hàng (
                                <c:choose>
                                    <c:when test="${cart.size() != 0 && cart != null}">
                                        ${cart.size()}
                                    </c:when>
                                    <c:otherwise>
                                        Empty
                                    </c:otherwise>
                                </c:choose>
                            ) <i class="fa fa-chevron-down"></i></div>
                        <div class="beta-dropdown cart-body">
                            <div class="cart-item">
                                <div class="media">
                                    <a class="pull-left" href="#"><img src="<c:url value='/resources/assets/dest/images/products/cart/1.png'/>" alt=""></a>
                                    <div class="media-body">
                                        <span class="cart-item-title">Sample Woman Top</span>
                                        <span class="cart-item-options">Size: XS; Colar: Navy</span>
                                        <span class="cart-item-amount">1*<span>$49.50</span></span>
                                    </div>
                                </div>
                            </div>

                            <div class="cart-item">
                                <div class="media">
                                    <a class="pull-left" href="#"><img src="<c:url value='/resources/assets/dest/images/products/cart/2.png'/>" alt=""></a>
                                    <div class="media-body">
                                        <span class="cart-item-title">Sample Woman Top</span>
                                        <span class="cart-item-options">Size: XS; Colar: Navy</span>
                                        <span class="cart-item-amount">1*<span>$49.50</span></span>
                                    </div>
                                </div>
                            </div>

                            <div class="cart-item">
                                <div class="media">
                                    <a class="pull-left" href="#"><img src="<c:url value='/resources/assets/dest/images/products/cart/3.png'/>" alt=""></a>
                                    <div class="media-body">
                                        <span class="cart-item-title">Sample Woman Top</span>
                                        <span class="cart-item-options">Size: XS; Colar: Navy</span>
                                        <span class="cart-item-amount">1*<span>$49.50</span></span>
                                    </div>
                                </div>
                            </div>

                            <div class="cart-caption">
                                <div class="cart-total text-right">Tổng tiền: <span class="cart-total-value">$34.55</span></div>
                                <div class="clearfix"></div>

                                <div class="center">
                                    <div class="space10">&nbsp;</div>
                                    <a href="checkout.html" class="beta-btn primary text-center">Đặt hàng <i class="fa fa-chevron-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </div> <!-- .cart -->
                </div>
            </div>
            <div class="clearfix"></div>
        </div> <!-- .container -->
    </div> <!-- .header-body -->
    <c:import url="menu.jsp"/>
</div> <!-- #header -->