package com.example.toolbarlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

public class LdyToolBar extends RelativeLayout {

    private boolean mIncludeStatusBar;

    private int mBackground;
    private boolean mShowBack;
    private int mBackImgRes;
    private String mTitleStr;
    private int mTitleColor;
    private int mTitleSize;
    private boolean mShowMenuLeft;
    private int mMenuImgLeftRes;
    private boolean mShowMenuRight;
    private int mMenuImgRightRes;
    private boolean mShowMenuText;
    private String mMenuTextStr;
    private int mMenuTextColor;
    private int mMenuTextSize;

    private Toolbar mToolbar;
    private ImageView mBackImg;
    private TextView mTitle;
    private ImageView mMenuImgLeft;
    private ImageView mMenuImgRight;
    private TextView mMenuText;

    public LdyToolBar(Context context) {
        super(context);
    }

    public LdyToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.toolbar_public_layout,this);

        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.LdyToolBar);

        mIncludeStatusBar = ta.getBoolean(R.styleable.LdyToolBar_includeStatusBar,true);
        mBackground = ta.getResourceId(R.styleable.LdyToolBar_backgroundRes, R.drawable.toolbar_bg);

        mShowBack = ta.getBoolean(R.styleable.LdyToolBar_showBack,true);
        mBackImgRes = ta.getResourceId(R.styleable.LdyToolBar_backImg,R.drawable.back_white);

        mTitleStr = "";
        mTitleStr = ta.getString(R.styleable.LdyToolBar_titleStr);
        mTitleColor = ta.getColor(R.styleable.LdyToolBar_titleColor,getResources().getColor(R.color.toolbarTitleColorDefault));
        mTitleSize = ta.getInteger(R.styleable.LdyToolBar_titleSize,17);

        mShowMenuLeft = ta.getBoolean(R.styleable.LdyToolBar_showMenuLeft,false);
        mMenuImgLeftRes = ta.getResourceId(R.styleable.LdyToolBar_menuImgLeft,R.drawable.back_white);

        mShowMenuRight = ta.getBoolean(R.styleable.LdyToolBar_showMenuRight,false);
        mMenuImgRightRes = ta.getResourceId(R.styleable.LdyToolBar_menuImgRight,R.drawable.back_white);

        mShowMenuText = ta.getBoolean(R.styleable.LdyToolBar_showMenuText,false);
        mMenuTextStr = ta.getString(R.styleable.LdyToolBar_menuTextStr);
        mMenuTextColor = ta.getColor(R.styleable.LdyToolBar_menuTextColor,getResources().getColor(R.color.toolbarTitleColorDefault));
        mMenuTextSize = ta.getInteger(R.styleable.LdyToolBar_menuTextSize,14);

        ta.recycle();

        initView();
    }

    private void initView(){

        //是否包含statusBar
        mToolbar = findViewById(R.id.toolbar);
        int top = mIncludeStatusBar?20:0;
        mToolbar.setPadding(0,top,0,0);

        //背景
        setBackgroundResource(mBackground);
        //返回图标
        mBackImg = findViewById(R.id.toolbar_public_back);
        if (mShowBack){
            mBackImg.setVisibility(VISIBLE);
            mBackImg.setImageResource(mBackImgRes);
        }else {
            mBackImg.setVisibility(GONE);
        }
        //标题
        mTitle = findViewById(R.id.toolbar_public_title);
        mTitle.setText(mTitleStr);
        mTitle.setTextColor(mTitleColor);
        mTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,mTitleSize);
        //menu btn left
        mMenuImgLeft = findViewById(R.id.toolbar_public_menu_img_btn_left);
        if (mShowMenuLeft){
            mMenuImgLeft.setVisibility(VISIBLE);
            mMenuImgLeft.setImageResource(mMenuImgLeftRes);
        }else {
            mMenuImgLeft.setVisibility(GONE);
        }
        //menu btn right
        mMenuImgRight = findViewById(R.id.toolbar_public_menu_img_btn_right);
        if (mShowMenuRight){
            mMenuImgRight.setVisibility(VISIBLE);
            mMenuImgRight.setImageResource(mMenuImgRightRes);
        }else {
            mMenuImgRight.setVisibility(GONE);
        }
        //menu text
        mMenuText = findViewById(R.id.toolbar_public_menu_text_btn);
        if (mShowMenuText){
            mMenuText.setVisibility(VISIBLE);
            mMenuText.setText(mMenuTextStr);
            mMenuText.setTextColor(mMenuTextColor);
            mMenuText.setTextSize(TypedValue.COMPLEX_UNIT_SP,mMenuTextSize);
        }else {
            mMenuText.setVisibility(GONE);
        }

    }

    /**
     * set toolBar titleStr
     * @param titleStr title string
     */
    public void setTitle(String titleStr){
        mTitle.setText(titleStr);
    }

    /**
     * back click action only finish
     * @param activity now activity
     */
    public void setBackClickFinish(final Activity activity){
        mBackImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    /**
     * back click action custom
     * @param listener click listener
     */
    public void setBackClickListener(OnClickListener listener){
        mBackImg.setOnClickListener(listener);
    }

    /**
     * menu left btn click action custom
     * @param listener click listener
     */
    public void setMenuLeftClickListener(OnClickListener listener){
        mMenuImgLeft.setOnClickListener(listener);
    }

    /**
     * menu right btn click action custom
     * @param listener click listener
     */
    public void setMenuRightClickListener(OnClickListener listener){
        mMenuImgRight.setOnClickListener(listener);
    }

    /**
     * menu text btn click action custom
     * @param listener click listener
     */
    public void setMenuTextClickListener(OnClickListener listener){
        mMenuText.setOnClickListener(listener);
    }

}
