

native method ledInit()
native method motorsInit()
native method motorsTestTask(int a)

method main():
  bool b = true

  ledInit()
  motorsInit()
  motorsTestTask(0)

  while(b):
  	b = true
