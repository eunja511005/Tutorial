<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/common/common.jsp" />
<title>Project</title>
</head>

<body id="page-top">
	<!-- Navigation-->
	<jsp:include page="/WEB-INF/jsp/common/nav.jsp" />


	<!-- Contact Section-->
	<section class="page-section" id="contact">
		<div class="container my-5">

			<!-- 페이지 제목 -->
			<h2
				class="page-section-heading text-center text-uppercase
				text-secondarymb-0">
				<c:choose>
					<c:when test="${empty project}">
						New Project
					</c:when>
					<c:otherwise>
						Edit Project
					</c:otherwise>
				</c:choose>
			</h2>

			<!-- 페이지 제목 아래 구분선 -->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>

			<!-- 페이지별 본문 -->
			<div class="container my-5">
				<div class="row justify-content-center">
					<div class="col-md-8">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">
									<c:choose>
										<c:when test="${empty project}">
											New Project
										</c:when>
										<c:otherwise>
											Edit Project
										</c:otherwise>
									</c:choose>
								</h4>
							</div>
							<div class="card-body">
								<form id="projectForm">
									<div class="form-group mb-3">
										<label for="name">프로젝트명</label> <input type="text"
											class="form-control" id="name" name="name"
											<c:if test="${!empty project}">value="${project.name}"</c:if>
											required>
									</div>
									<div class="form-group mb-3">
										<label for="description">프로젝트 설명</label>
										<textarea class="form-control" id="description"
											name="description" rows="3" required><c:if
												test="${!empty project}">${project.description}</c:if></textarea>
									</div>
									<div class="form-group mb-3">
										<label for="startDate">시작일</label> <input type="date"
											class="form-control" id="startDate" name="startDate"
											<c:if test="${!empty project}">value="${project.startDate}"</c:if>
											required>
									</div>
									<div class="form-group mb-3">
										<label for="endDate">종료일</label> <input type="date"
											class="form-control" id="endDate" name="endDate"
											<c:if test="${!empty project}">value="${project.endDate}"</c:if>
											required>
									</div>
									<div class="form-group mb-3">
										<label for="status">진행 상태</label> <select class="form-control"
											id="status" name="status" required>
											<option value="">선택하세요</option>
											<option value="준비중"
												<c:if test="${project != null && project.status == '준비중'}">selected</c:if>>
												준비중</option>
											<option value="진행중"
												<c:if test="${project != null && project.status == '진행중'}">selected</c:if>>
												진행중</option>
											<option value="완료"
												<c:if test="${project != null && project.status == '완료'}">selected</c:if>>
												완료</option>
											<option value="보류"
												<c:if test="${project != null && project.status == '보류'}">selected</c:if>>
												보류</option>
										</select>
									</div>
									<div class="form-group mb-3">
										<label for="manager">담당자</label> <input type="text"
											class="form-control" id="manager" name="manager" 
											<c:if test="${!empty project}">value="${project.manager}"</c:if>
											required>
									</div>
									<div class="form-group mb-3">
										<label for="participants">참여자</label> <select
											class="form-control" id="participants" name="participants[]"
											multiple required>
											<option value="">Select an option...</option>
											<option value="user1">User 1</option>
											<option value="user2">User 2</option>
											<option value="user3">User 3</option>
										</select>
									</div>
									<div class="text-center">
										<button id="submitButton" type="submit"
											class="btn btn-primary btn-lg">
											<c:if test="${empty project.id}">등록</c:if>
											<c:if test="${not empty project.id}">수정</c:if>
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="/WEB-INF/jsp/common/commonScript.jsp" />

	<!-- this page's javascript -->
	<script type="text/javascript" src="/js/project/projectInputForm.js"></script>

</body>
</html>