@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG408() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG410() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG412() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG414() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG416() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG418() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG420() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG422() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG424() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG426() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG428() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG430() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG432() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG434() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG436() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG438() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG440() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG442() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG444() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG446() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG448() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG450() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG452() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG454() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG456() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG458() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG460() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG462() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG464() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG466() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG468() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG470() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG472() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG474() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG476() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG478() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG480() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG482() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG484() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG486() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG488() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG490() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG492() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG494() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG496() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG498() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG500() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG502() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG504() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG506() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG508() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG510() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG512() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG514() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG516() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG518() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG520() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG522() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG524() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG526() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG528() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG530() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG532() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG534() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG536() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG538() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG540() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG542() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG544() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG546() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG548() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG550() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG552() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG554() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG556() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG558() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG560() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG562() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG564() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG566() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG568() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG570() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG572() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG574() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG576() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG578() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG580() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG582() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG584() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG586() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG588() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG590() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG592() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG594() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG596() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG598() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG600() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}
@org.junit.Test(timeout = 10000)
public void importStaticReadmeExample_Ex2_CATG602() {
    com.squareup.javapoet.ClassName hoverboard = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName namedBoards = com.squareup.javapoet.ClassName.get("", "", "");
    com.squareup.javapoet.ClassName list = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.ClassName arrayList = com.squareup.javapoet.ClassName.get("", "");
    com.squareup.javapoet.TypeName listOfHoverboards = com.squareup.javapoet.ParameterizedTypeName.get(list, hoverboard);
    com.squareup.javapoet.MethodSpec beyond = com.squareup.javapoet.MethodSpec.methodBuilder("b").returns(listOfHoverboards).addStatement("$T result = new $T<", listOfHoverboards, arrayList).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.", hoverboard).addStatement("result.add($T.createNimbus($T.", hoverboard, namedBoards).addStatement("$T.", java.util.Collections.class).addStatement("return result.isEmpty() $T", java.util.Collections.class).build();
    com.squareup.javapoet.TypeSpec hello = com.squareup.javapoet.TypeSpec.classBuilder("").addMethod(beyond).build();
    com.squareup.javapoet.JavaFile example = com.squareup.javapoet.JavaFile.builder("", hello).addStaticImport(hoverboard, "").addStaticImport(namedBoards, "").addStaticImport(java.util.Collections.class, "").build();
}