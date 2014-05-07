CC=gcc
CFLAGS=-I.
DEPS = hellomake.h
OBJ = hellomake.c hellofunc.c

%.o: %.c $(DEPS)
	$(CC) -c -o $@ %< $(CFLAGS)

hellomake: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)
