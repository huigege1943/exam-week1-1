# Android ��ͼ���������б�
## �������ϲ�ѯ��������⣺

### android view������14�����ڣ�
1. onFinishInflate() ��View�����е��ӿؼ�����ӳ���xml�󴥷� ��
2. onMeasure( int ,  int ) ȷ��������Ԫ�صĴ�С ��
3. onLayout( boolean ,  int ,  int ,  int ,  int ) ��View�������е���Ԫ�صĴ�С��λ��ʱ���� ��
4. onSizeChanged( int ,  int ,  int ,  int ) ��view�Ĵ�С�����仯ʱ����  ��
5. onDraw(Canvas) view��Ⱦ���ݵ�ϸ�ڡ�  
6. onKeyDown( int , KeyEvent) �а������º󴥷�  ��
7. onKeyUp( int , KeyEvent) �а������º���ʱ����  ��
8. onTrackballEvent(MotionEvent) �켣���¼� �� 
9. onTouchEvent(MotionEvent) �����¼�  ��
10. onFocusChanged( boolean ,  int , Rect) ��View��ȡ��ʧȥ����ʱ����   ��
11. onWindowFocusChanged( boolean ) �����ڰ�����view��ȡ��ʧȥ����ʱ����  ��
12. onAttachedToWindow() ��view�����ŵ�һ������ʱ����  ��
13. onDetachedFromWindow() ��view�뿪���ŵĴ���ʱ������Android123��ʾ�÷�����  onAttachedToWindow() ���෴�ġ�  
14. onWindowVisibilityChanged( int ) �������а����Ŀɼ���view�����仯ʱ������

### View �Ĺؼ���������Ϊ��
[�ı�ɼ���] --> ����View --> onFinishInflate --> onAttachedToWindow --> onMeasure --> onSizeChanged --> onLayout --> onDraw --> onDetackedFromWindow