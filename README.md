# LdyToolBar
[![](https://jitpack.io/v/LDYSummer/LdyToolBar.svg)](https://jitpack.io/#LDYSummer/LdyToolBar)
快速设置ToolBar
- 自定义toolbar背景颜色或图片
- 自定义返回图标/标题/其他功能按钮
- 右侧功能按钮 图标类最多2个/文字类最多1个

### 添加项目依赖
#### build.gradle
```javascript
  allprojects {
    repositories {
     ...
     maven { url 'https://jitpack.io' }
    }
  }
```

#### dependency
```javascript
  dependencies {
      implementation 'com.github.LDYSummer:LdyToolBar:1.0.3'
  }
```
### 属性说明

|名称 | 属性 | 参数说明 |
|-----|-----|-----------
|toolbar背景颜色 | app:backgroundRes | reference color/drawable-res 默认为colorPrimary res |
|是否显示返回图标| app:showBack | boolean 默认为true |
|设置返回图标res | app:backImg | resource id 默认为system back ios #ffffff |
|设置标题 | app:titleStr | string |
|设置标题颜色 | app:titleColor | color 默认#ffffff |
|是否显示功能按钮(图标)左 | app:showMenuLeft | boolean 默认为false |
|设置功能按钮(左)图标 | app:menuImgLeft | resourc id |
|是否显示功能按钮(图标)右 | app:showMenuRight | boolean 默认为false |
|设置功能按钮(右)图标 | app:menuImgRight | resourc id |
|是否显示功能按钮(文字) | app:showMenuText | boolean 默认为false |
|设置功能按钮(文字)标题 | app:menuTextStr | string |
|设置功能按钮(文字)颜色 | app:menuTextColor | color 默认#ffffff | 

### 使用
#### XML
```javascript
    <com.example.toolbardemo.LdyToolBar
        android:id="@+id/main_toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:titleStr="@string/app_name"
        app:showMenuLeft="true"
        app:menuImgLeft="@drawable/add"
        app:showMenuRight="true"
        app:menuImgRight="@drawable/download" />

```
```javascript
    <com.example.toolbardemo.LdyToolBar
        android:id="@+id/main_toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:titleStr="@string/app_name"
        app:showMenuText="true"
        app:menuTextStr="@string/menuText"/>
```

#### 返回点击事件
- 仅finish
```javascript
    toolBar.setBackClickFinish(MainActivity.this);
```

- 自定义事件
```javascript
    toolBar.setBackClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ...
        }
    });
```

#### 功能按钮 图标 左 点击事件
```javascript
    toolBar.setMenuLeftClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ...
        }
    });
```

#### 功能按钮 图标 右 点击事件
```javascript
    toolBar.setMenuRightClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ...
        }
    });
```

#### 功能按钮 文字 点击事件
```javascript
    toolBar.setMenuTextClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ...
        }
    });
```
#### 动态设置标题
```javascript
    toolBar.setTitle("");
```
