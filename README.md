# 👤 GARNIER-GULINO Enzo - M1 ILSEN 👤

## 📜 UCE Génie Logiciel Avancé : Techniques de tests 📜

### ✅ Code Coverage ✅

[![CircleCI](https://circleci.com/gh/EnzoGarnierGulino/ceri-m1-techniques-de-test.svg?style=svg)](https://circleci.com/gh/EnzoGarnierGulino/ceri-m1-techniques-de-test)
[![codecov](https://codecov.io/gh/EnzoGarnierGulino/ceri-m1-techniques-de-test/graph/badge.svg?token=A0Z6EK8Q6X)](https://codecov.io/gh/EnzoGarnierGulino/ceri-m1-techniques-de-test)

### 🔍 Checkstyle 🔍

![Checkstyle](https://img.shields.io/badge/dynamic/xml?label=Checkstyle&query=%2F%2Ferror&url=https://gist.github.com/EnzoGarnierGulino/fb5d190ff6ed9baacb85fc761c0ba1cf.js)
![Checkstyle](https://img.shields.io/badge/Checkstyle-Passed-brightgreen)

The first checkstyle badge is the one linked to my project. It says "no result" because no vulnerabilities or issues 
were found, so the generated .xml file is empty. 
But because I want my project to be pretty, I added a second badge using the default "passed" template.

### 📚 Javadoc 📚

https://enzogarniergulino.github.io/ceri-m1-techniques-de-test/fr/univavignon/pokedex/api/package-summary.html

### ❓ Some informations ❓

Codecov says I'm covering 98% of the lines of the project. It is not 100% because the two lines I should now cover are the "catch" part of a "try / catch" block in a method.
To cover them, I should add an exception signature in each method using the method containing the "try / catch" block : it would be totally useless and it would just make the code more complicated.
So I've decided to not cover this method : that's why my Codecov says 98% instead of 100.
