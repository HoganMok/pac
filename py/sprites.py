from PIL import Image
import numpy as np
import sys

COLOR_SEP = (0, 102, 102)
global_palette = []
global_image = None

def set_image(input_path):
    global global_image 
    global_image = Image.open(input_path)

def set_palette():
    global global_palette
    global global_image
    palette = global_image.getpalette()
    print(palette)
    global_palette = np.array(palette).reshape(len(palette) // 3, 3)

def get_pixel_color(xy):
    global global_image
    global global_palette
    palette_i = global_image.getpixel(xy)
    color = tuple(global_palette[palette_i])
    return color


def select_gameboard(input_path):
    global global_image
    
    x = 224; y = 0
    red, green, blue = get_pixel_color(xy=(x, y))
    start = [0, 0]
    tracer_x = [0, 0]
    tracer_y = [0, 0]
    color_1 = get_pixel_color(tuple(tracer_x))
    color_2 = get_pixel_color(tuple(tracer_y))

    while (color_1 != COLOR_SEP or color_2 != COLOR_SEP):
        if (color_1 != COLOR_SEP):
            tracer_x[0]+=1
            color_1 = get_pixel_color(tuple(tracer_x))
        if (color_2 != COLOR_SEP):
            tracer_y[1]+=1
            color_2 = get_pixel_color(tuple(tracer_y))

    left = start[0]
    top = start[1]
    right = start[0] + tracer_x[0]
    bottom = start[1] + tracer_y[1]
    gameboard = global_image.crop(left, top, right, bottom)
        
    print("Pixel color", red, green, blue)

def select_sprite_board():
    global global_image
    xy = [0, 0]
    color = get_pixel_color(xy=tuple(xy))
    count = 0

    while((color != COLOR_SEP or count < 2) and xy[1] < global_image.height-1):
        xy[1]+=1
        color = get_pixel_color(xy=tuple(xy))
        if (color == COLOR_SEP): count+=1
    
    left = 0
    top = xy[1]
    right = global_image.width-1
    bottom = global_image.height-1
    
    cropping = global_image.crop((left, top, right, bottom))
    sprite_board = Image.new("P", cropping.size)
    sprite_board.putpalette(global_image.getpalette())
    sprite_board.paste(cropping, (0, 0))
    sprite_board.save("images/sprites.png")
    
def select_big_pac():
    global global_image
    left = 0
    top = 0
    right = 100
    bottom = 133

    cropping = global_image.crop((left, top, right, bottom))
    big_pac = Image.new("P", cropping.size)
    big_pac.putpalette(global_image.getpalette())
    big_pac.paste(cropping, (0, 0))
    big_pac.save("images/big_pac.png")

def select_lil_pac():
    global global_image
    left = 99
    top = 0
    right = left + 52
    bottom = 69

    cropping = global_image.crop((left, top, right, bottom))
    lil_pac = Image.new("P", cropping.size)
    lil_pac.putpalette(global_image.getpalette())
    lil_pac.paste(cropping, (0, 0))
    lil_pac.save("images/lil_pac.png")

def select_dead_pac():
    global global_image
    left = 99 + 52 - 1
    top = 0
    right = left + 188
    bottom = 18

    cropping = global_image.crop((left, top, right, bottom))
    dead_pac = Image.new("P", cropping.size)
    dead_pac.putpalette(global_image.getpalette())
    dead_pac.paste(cropping, (0, 0))
    dead_pac.save("images/dead_pac.png")
    
def select_red_enemy():
    global global_image
    image_name = "red_enemy.png"
    left = 99
    top = 68
    right = left + 290
    bottom = top + 18

    cropping = global_image.crop((left, top, right, bottom))
    red_enemy = Image.new("P", cropping.size)
    red_enemy.putpalette(global_image.getpalette())
    red_enemy.paste(cropping, (0, 0))
    red_enemy.save("images/"+image_name)

def select_pink_enemy():
    global global_image
    image_name = "pink_enemy.png"
    left = 99
    top = 68 + 18 - 1
    right = left + 290
    bottom = top + 18

    cropping = global_image.crop((left, top, right, bottom))
    red_enemy = Image.new("P", cropping.size)
    red_enemy.putpalette(global_image.getpalette())
    red_enemy.paste(cropping, (0, 0))
    red_enemy.save("images/"+image_name)

def select_blue_enemy():
    global global_image
    image_name = "blue_enemy.png"
    left = 99
    top = 68 + (18 - 1)*2
    right = left + 290
    bottom = top + 18

    cropping = global_image.crop((left, top, right, bottom))
    red_enemy = Image.new("P", cropping.size)
    red_enemy.putpalette(global_image.getpalette())
    red_enemy.paste(cropping, (0, 0))
    red_enemy.save("images/"+image_name)

def select_yellow_enemy():
    global global_image
    image_name = "yellow_enemy.png"
    left = 99
    top = 68 + (18 - 1)*3
    right = left + 290
    bottom = top + 18

    cropping = global_image.crop((left, top, right, bottom))
    red_enemy = Image.new("P", cropping.size)
    red_enemy.putpalette(global_image.getpalette())
    red_enemy.paste(cropping, (0, 0))
    red_enemy.save("images/"+image_name)

def select_tiles():

    return
    


def main():
    image_filepath = "images/" + sys.argv[1]
    # select_gameboard(sprite_board)
    set_image(image_filepath)
    set_palette()
    # select_tiles()
    # select_sprite_board()
    # select_big_pac()
    # select_lil_pac()
    # select_dead_pac()
    # select_red_enemy()
    # select_pink_enemy()
    # select_blue_enemy()
    select_yellow_enemy()





if __name__=="__main__":
    main()