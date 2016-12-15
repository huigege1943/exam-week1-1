# Android 视图生命周期列表
## 网上资料查询但还不理解：

### android view有以下14个周期：
1. onFinishInflate() 当View中所有的子控件均被映射成xml后触发 。
2. onMeasure( int ,  int ) 确定所有子元素的大小 。
3. onLayout( boolean ,  int ,  int ,  int ,  int ) 当View分配所有的子元素的大小和位置时触发 。
4. onSizeChanged( int ,  int ,  int ,  int ) 当view的大小发生变化时触发  。
5. onDraw(Canvas) view渲染内容的细节。  
6. onKeyDown( int , KeyEvent) 有按键按下后触发  。
7. onKeyUp( int , KeyEvent) 有按键按下后弹起时触发  。
8. onTrackballEvent(MotionEvent) 轨迹球事件 。 
9. onTouchEvent(MotionEvent) 触屏事件  。
10. onFocusChanged( boolean ,  int , Rect) 当View获取或失去焦点时触发   。
11. onWindowFocusChanged( boolean ) 当窗口包含的view获取或失去焦点时触发  。
12. onAttachedToWindow() 当view被附着到一个窗口时触发  。
13. onDetachedFromWindow() 当view离开附着的窗口时触发，Android123提示该方法和  onAttachedToWindow() 是相反的。  
14. onWindowVisibilityChanged( int ) 当窗口中包含的可见的view发生变化时触发。

### View 的关键生命周期为：
[改变可见性] --> 构造View --> onFinishInflate --> onAttachedToWindow --> onMeasure --> onSizeChanged --> onLayout --> onDraw --> onDetackedFromWindow