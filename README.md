WheelView
=========

Android滚动选择控件


<img src='https://raw.githubusercontent.com/wangjiegulu/WheelView/master/image/image01.png' height='500px'/>
<img src='https://raw.githubusercontent.com/wangjiegulu/WheelView/master/image/image02.png' height='500px'/>
<img src='https://raw.githubusercontent.com/wangjiegulu/WheelView/master/image/image03.png' height='500px'/>



    实现Android竖直滚动选择功能
    注意：
        1. 此demo中注解、日志等功能使用了AndroidInject（https://github.com/wangjiegulu/androidInject）
            和AndroidBucket（https://github.com/wangjiegulu/AndroidBucket）项目
        2. 此demo中每一个滑动的选项都是一个View，未使用View的缓存，待优化！
        
      
      使用方式：
      /**
       * Author: wangjie
       * Email: tiantian.china.2@gmail.com
       * Date: 7/1/14.
       */
      @AILayout(R.layout.main)
      public class MainActivity extends AIActivity {
          public static final String TAG = MainActivity.class.getSimpleName();
      
          private static final String[] PLANETS = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Uranus", "Neptune", "Pluto"};
      
          @AIView(R.id.main_wv)
          private WheelView wva;
      
          @Override
          public void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
              wva.setOffset(1);
              wva.setItems(Arrays.asList(PLANETS));
              wva.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
                  @Override
                  public void onSelected(int selectedIndex, String item) {
                      Logger.d(TAG, "selectedIndex: " + selectedIndex + ", item: " + item);
                  }
              });
      
      
          }
          
          @AIClick({R.id.main_show_dialog_btn})
          public void onClickCallbackSample(View view) {
              switch (view.getId()) {
                  case R.id.main_show_dialog_btn:
                      View outerView = LayoutInflater.from(context).inflate(R.layout.wheel_view, null);
                      WheelView wv = (WheelView) outerView.findViewById(R.id.wheel_view_wv);
                      wv.setOffset(2);
                      wv.setItems(Arrays.asList(PLANETS));
                      wv.setSeletion(3);
                      wv.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
                          @Override
                          public void onSelected(int selectedIndex, String item) {
                              Logger.d(TAG, "[Dialog]selectedIndex: " + selectedIndex + ", item: " + item);
                          }
                      });
      
                      new AlertDialog.Builder(context)
                              .setTitle("WheelView in Dialog")
                              .setView(outerView)
                              .setPositiveButton("OK", null)
                              .show();
      
                      break;
              }
          }


    } 
    
License
=======

    Copyright 2014 Wang Jie

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
