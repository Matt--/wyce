

native method ledInit()
native method ledSet(int a, int b)

method main():
  int LED_RED = 0
  int LED_GREEN = 1

  bool b = true
  ledInit()
  ledSet(LED_RED, 1)
  ledSet(LED_GREEN, 1)

  while(b):
  	b = true
