<!-- http://www.hongkiat.com/blog/html5-loginpage/ -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/bootstrap-theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/simple-sidebar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/jquery.dataTables.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/css/fontawesome-all.css">

<script src="${pageContext.request.contextPath }/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
<script
	src="${pageContext.request.contextPath }/static/js/jquery.dataTables.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/style.css">

<style type="text/css">
.error {
	color: red
}
/* password widget */
.pwdfield {
	width: 100%;
}

.pwdopsdiv {
	display: block;
	float: left;
	margin-right: 6px;
}

.pwdopsdiv a {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 10px;
}

.pwdstrengthbar {
	float: right;
	background: #cccccc;
	height: 4px;
	margin: 0;
}

.pwdstrength {
	float: right;
	height: 20px;
	width: 70px;
	margin-top: 3px;
}

.pwdstrengthstr {
	float: right;
	clear: both;
	height: 14px;
	margin-top: 0px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 10px;
}
</style>

<script type="text/javascript">
	function PasswordWidget(divid, pwdname) {
		this.maindivobj = document.getElementById(divid);
		this.pwdobjname = pwdname;

		this.MakePWDWidget = _MakePWDWidget;

		this.showing_pwd = 1;
		this.txtShow = 'Show';
		this.txtMask = 'Mask';
		this.txtGenerate = 'Generate';
		this.txtWeak = 'weak';
		this.txtMedium = 'medium';
		this.txtGood = 'good';

		this.enableShowMask = true;
		this.enableGenerate = true;
		this.enableShowStrength = true;
		this.enableShowStrengthStr = true;

	}

	function _MakePWDWidget() {
		var code = "";
		var pwdname = this.pwdobjname;

		this.pwdfieldid = pwdname + "_id";

		code += "<input type='password' class='form-control' placeholer='pwdfield' name='"+pwdname+"' id='"+this.pwdfieldid+"'>";

		this.pwdtxtfield = pwdname + "_text";

		this.pwdtxtfieldid = this.pwdtxtfield + "_id";

		code += "<input type='text' class='form-control pwdfield' name='"+this.pwdtxtfield+"' id='"+this.pwdtxtfieldid+"' style='display: none;'>";

		this.pwdshowdiv = pwdname + "_showdiv";

		this.pwdshow_anch = pwdname + "_show_anch";

		code += "<div class='pwdopsdiv' id='"+this.pwdshowdiv+"'><a href='#' id='"+this.pwdshow_anch+"'>"
				+ this.txtShow + "</a></div>";

		this.pwdgendiv = pwdname + "_gendiv";

		this.pwdgenerate_anch = pwdname + "_gen_anch";

		code += "<div class='pwdopsdiv'id='"+this.pwdgendiv+"'><a href='#' id='"+this.pwdgenerate_anch+"'>"
				+ this.txtGenerate + "</a></div>";

		this.pwdstrengthdiv = pwdname + "_strength_div";

		code += "<div class='pwdstrength' id='"+this.pwdstrengthdiv+"'>";

		this.pwdstrengthbar = pwdname + "_strength_bar";

		code += "<div class='pwdstrengthbar' id='"+this.pwdstrengthbar+"'></div>";

		this.pwdstrengthstr = pwdname + "_strength_str";

		code += "<div class='pwdstrengthstr' id='"+this.pwdstrengthstr+"'></div>";

		code += "</div>";

		this.maindivobj.innerHTML = code;

		this.pwdfieldobj = document.getElementById(this.pwdfieldid);

		this.pwdfieldobj.pwdwidget = this;

		this.pwdstrengthbar_obj = document.getElementById(this.pwdstrengthbar);

		this.pwdstrengthstr_obj = document.getElementById(this.pwdstrengthstr);

		this._showPasswordStrength = passwordStrength;

		this.pwdfieldobj.onkeyup = function() {
			this.pwdwidget._onKeyUpPwdFields();
		}

		this._showGeneatedPwd = showGeneatedPwd;

		this.generate_anch_obj = document.getElementById(this.pwdgenerate_anch);

		this.generate_anch_obj.pwdwidget = this;

		this.generate_anch_obj.onclick = function() {
			this.pwdwidget._showGeneatedPwd();
		}

		this._showpwdchars = showpwdchars;

		this.show_anch_obj = document.getElementById(this.pwdshow_anch);

		this.show_anch_obj.pwdwidget = this;

		this.show_anch_obj.onclick = function() {
			this.pwdwidget._showpwdchars();
		}

		this.pwdtxtfield_obj = document.getElementById(this.pwdtxtfieldid);

		this.pwdtxtfield_obj.pwdwidget = this;

		this.pwdtxtfield_obj.onkeyup = function() {
			this.pwdwidget._onKeyUpPwdFields();
		}

		this._updatePwdFieldValues = updatePwdFieldValues;

		this._onKeyUpPwdFields = onKeyUpPwdFields;

		if (!this.enableShowMask) {
			document.getElementById(this.pwdshowdiv).style.display = 'none';
		}

		if (!this.enableGenerate) {
			document.getElementById(this.pwdgendiv).style.display = 'none';
		}

		if (!this.enableShowStrength) {
			document.getElementById(this.pwdstrengthdiv).style.display = 'none';
		}

		if (!this.enableShowStrengthStr) {
			document.getElementById(this.pwdstrengthstr).style.display = 'none';
		}
	}

	function onKeyUpPwdFields() {
		this._updatePwdFieldValues();
		this._showPasswordStrength();
	}

	function updatePwdFieldValues() {
		if (1 == this.showing_pwd) {
			this.pwdtxtfield_obj.value = this.pwdfieldobj.value;
		} else {
			this.pwdfieldobj.value = this.pwdtxtfield_obj.value;
		}
	}

	function showpwdchars() {
		var innerText = '';
		var pwdfield = this.pwdfieldobj;
		var pwdtxt = this.pwdtxtfield_obj;
		var field;
		if (1 == this.showing_pwd) {
			this.showing_pwd = 0;
			innerText = this.txtMask;

			pwdtxt.value = pwdfield.value;
			pwdfield.style.display = 'none';
			pwdtxt.style.display = '';
			pwdtxt.focus();
		} else {
			this.showing_pwd = 1;
			innerText = this.txtShow;
			pwdfield.value = pwdtxt.value;
			pwdtxt.style.display = 'none';
			pwdfield.style.display = '';
			pwdfield.focus();

		}
		this.show_anch_obj.innerHTML = innerText;

	}

	function passwordStrength() {
		var colors = new Array();
		colors[0] = "#cccccc";
		colors[1] = "#ff0000";
		colors[2] = "#ff5f5f";
		colors[3] = "#56e500";
		colors[4] = "#4dcd00";
		colors[5] = "#399800";

		var pwdfield = this.pwdfieldobj;
		var password = pwdfield.value

		var score = 0;

		if (password.length > 6) {
			score++;
		}

		if ((password.match(/[a-z]/)) && (password.match(/[A-Z]/))) {
			score++;
		}

		if (password.match(/\d+/)) {
			score++;
		}

		if (password.match(/[^a-z\d]+/)) {
			score++
		}
		;

		if (password.length > 12) {
			score++;
		}

		var color = colors[score];
		var strengthdiv = this.pwdstrengthbar_obj;

		strengthdiv.style.background = colors[score];

		if (password.length <= 0) {
			strengthdiv.style.width = 0;
		} else {
			strengthdiv.style.width = (score + 1) * 10 + 'px';
		}

		var desc = '';
		if (password.length < 1) {
			desc = '';
		} else if (score < 3) {
			desc = this.txtWeak;
		} else if (score < 4) {
			desc = this.txtMedium;
		} else if (score >= 4) {
			desc = this.txtGood;
		}

		var strengthstrdiv = this.pwdstrengthstr_obj;
		strengthstrdiv.innerHTML = desc;
	}

	function getRand(max) {
		return (Math.floor(Math.random() * max));
	}

	function shuffleString(mystr) {
		var arrPwd = mystr.split('');

		for (i = 0; i < mystr.length; i++) {
			var r1 = i;
			var r2 = getRand(mystr.length);

			var tmp = arrPwd[r1];
			arrPwd[r1] = arrPwd[r2];
			arrPwd[r2] = tmp;
		}

		return arrPwd.join("");
	}

	function showGeneatedPwd() {
		var pwd = generatePWD();
		this.pwdfieldobj.value = pwd;
		this.pwdtxtfield_obj.value = pwd;

		this._showPasswordStrength();
	}

	function generatePWD() {
		var maxAlpha = 26;
		var strSymbols = "~!@#$%^&*(){}?><`=-|][";
		var password = '';
		for (i = 0; i < 3; i++) {
			password += String.fromCharCode("a".charCodeAt(0)
					+ getRand(maxAlpha));
		}
		for (i = 0; i < 3; i++) {
			password += String.fromCharCode("A".charCodeAt(0)
					+ getRand(maxAlpha));
		}
		for (i = 0; i < 3; i++) {
			password += String.fromCharCode("0".charCodeAt(0) + getRand(10));
		}
		for (i = 0; i < 4; i++) {
			password += strSymbols.charAt(getRand(strSymbols.length));
		}

		password = shuffleString(password);
		password = shuffleString(password);
		password = shuffleString(password);

		return password;
	}
</script>

</head>
<body>

	<div class="col-xs-6 well">Tag Recognization System.</div>
	<div class="col-xs-6 ">
		<h3 class="error">${loginError}</h3>
		<section class="loginform cf">
			<form action="login" method="post" accept-charset="utf-8">
				<ul>
					<li><label for="username">Username</label> <input type="text"
						name="username" placeholder="username" required></li>
					<li><label for="password">Password</label> <input
						type="password" name="password" placeholder="password" required></li>
					<li><input type="submit" value="Login"></li>
				</ul>
			</form>
		</section>
	</div>
	<hr />

	<div class="container">
		<div class="row">
			<div class="col-xs-7">
				<div class="well" style="padding: 20px;">
				Welcome to Sahan Dhakal Auto tag
					Recognization system will help to find possible tags related to the
					question automatically, we have crawled set of question from
					different domains and made some training set of data to train our
					tagging model, so that it can decide tag subject which is based on
					naive based algorithm. Once question is asked, my system will
					remove stop words , do streaming and also perform pre pressings to
					get main subjective word. Then we pass such word in the naive based
					algorithm, which guess possible tags based on training set of data
					and decide by checking highest priority. So, most possible word
					will be considered as a Tags. More training set of data we have
					accuracy level will also get increased.</div>
			</div>
			<div class="col-xs-5 col-sm-12 col-md-4 well well-sm">
				<legend>
					<a href="http://www.jquery2dotnet.com"><i
						class="glyphicon glyphicon-globe"></i></a> Sign up!
				</legend>
				<h3 class="error">${signupError}</h3>
				<form action="signup" method="post" class="form" role="form">
					<div class="row">
						<div class="col-xs-6 col-md-6">
							<input class="form-control" name="firstname"
								placeholder="First Name" type="text"
								value="${signupUser.firstName }" required autofocus />
						</div>
						<div class="col-xs-6 col-md-6">
							<input class="form-control" name="lastname"
								placeholder="Last Name" type="text"
								value="${signupUser.lastName }" required />
						</div>
					</div>
					<input class="form-control" name="youremail"
						placeholder="Your Email" type="email" value="${signupUser.email }" />
					<input class="form-control" name="reenteremail"
						placeholder="Re-enter Email" type="email"
						value="${signupUser.reenteremail}" />
					<div class="row">
						<div class='col-xs-12' id='thepwddiv'></div>
						<script type="text/javascript">
							var pwdwidget = new PasswordWidget('thepwddiv',
									'regpwd');
							pwdwidget.MakePWDWidget();
						</script>
						<noscript>
							<div>
								<input class="form-control" type='password' name='regpwd'
									value="${signupUser.password }" autocomplete="false" />
							</div>
						</noscript>
					</div>
					<input class="form-control" name="birthDate"
						placeholder="Your Birth Date: yyyy-MM-dd" type="date"
						value="${birthDate}" />
					<!-- 
            <label for="">
                Birth Date</label>
            <div class="row">
                <div class="col-xs-4 col-md-4">
                    <select class="form-control">
                        <option value="Month">Month</option>
                    </select>
                </div>
                <div class="col-xs-4 col-md-4">
                    <select class="form-control">
                        <option value="Day">Day</option>
                    </select>
                </div>
                <div class="col-xs-4 col-md-4">
                    <select class="form-control">
                        <option value="Year">Year</option>
                    </select>
                </div>
            </div>
             -->
					<label class="radio-inline"> <input type="radio"
						name="gender" id="inlineCheckbox1" value="male"
						<c:if test="${signupUser != null && signupUser.gender == 'male'}">checked</c:if> />
						Male
					</label> <label class="radio-inline"> <input type="radio"
						name="gender" id="inlineCheckbox2" value="female"
						<c:if test="${signupUser != null && signupUser.gender == 'female'}">checked</c:if> />
						Female
					</label> <br /> <br />
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						Sign up</button>
					<input style="display: none" type="email"
						name="fakeusernameremembered" /> <input style="display: none"
						type="password" name="fakepasswordremembered" />
				</form>
			</div>

		</div>
	</div>
</body>
</html>