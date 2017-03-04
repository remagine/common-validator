# common-validator

 gitlab프로젝트를 github으로 옮겼습니다.

 ## Ver 0.0.1


 - length(String src, int min, int max)
  Stirng 최소값, 최대값 판별

 - email(String src)
  Email 형식 판별

 - phone(Stirng src)
 일반전화 형식 판별, 0#(#)-###(#)-#### , -포함

 - moblie(Stirng src)
 핸드폰 형식 validator, 01#-####-#### , -포함

 - alpha(String src)
 영문(대소문자) 형식 validator, 공백문자불가

 - alphaLower(String src)
 영문(소문자) 형식 validator, 공백문자불가

 - alphaUpper(String src)
 영문(대문자) 형식 validator, 공백문자불가

 - alphanum(String src)
 영문(대소문자) + 숫자 형식 validator, 공백문자불가

 - alphanumLower(String src)
 영문(소문자) + 숫자 형식 validator, 공백문자불가

 - alphanumUpper(String src)
 영문(대문자) + 숫자 형식 validator, 공백문자불가

 - identifier(String src)
 ID 형식 validator, 공백문자불가 , 영문(대소문자) + 숫자 + "_"

 - identifierLower(String src)
 ID 소문자 형식 validator, 공백문자불가 , 영문(소문자) + 숫자 + "_"

 - identifierUpper(String src)
 ID 대문자 형식 validator, 공백문자불가 , 영문(대문자) + 숫자 + "_"

 - cssClassName(String src)
 CSS 형식 validator, 공백문자불가 , 숫자시작불가, 영문(대소문자) + 숫자 + "_" + "-"

 - number(String src)
 숫자 형식 validator, 공백문자불가 , 앞에 0이 붙어도 상관없음(오직 양수만)

 - integerNumber(String src)
 정수 숫자 형식 validator, 음수 - 0 - 양수 (단 0으로 시작하는 2자리 이상 수는 false)

 - floatNumber(String src)   
 실수 숫자 형식 validator, 음수 - 0 - 양수 (단 0으로 시작하는 2자리 이상 수는 false, 숫자 자리수 제한 X)

 - floatNumber(String src, int size)    
 실수 숫자 형식 validator, 음수 - 0 - 양수 (단 0으로 시작하는 2자리 이상 수는 false, 숫자 자리수 제한 size)

 - zipcode(String src)  
 우편변호 형식 validator, ###-### 구우편번호 or 5자리 신우편번호

 - url(String src)     
 url 형식 validator, http:// & https:// only

 - path(String src)
 path 형식 validator, File 경로 확인 (D:\directoryname\testing\text.txt
 ,\john-desktop\tempdir\ssh.ppk)

 - path(String src, String... extensions)
 path 형식 validator, File 경로 확인 , 주어진 확장자의 파일인지 확인

 - imagePath(String src)
 imagePath 형식 validator, image File 경로 확인 (jpeg,jpg,gif,png)       
     
