from PIL import Image
import numpy as np

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
    print(count)
    print(left, top, right, bottom)

    sprite_board = global_image.crop((left, top, right, bottom))
    # sprite_board.show()
    sprite_board.save("images/sprites.png")
    
def select_enemy_sprites():
    global global_image


    


def main():
    image_filepath = "images/sprite_board.png"
    # select_gameboard(sprite_board)
    set_image(image_filepath)
    set_palette()

    # select_sprite_board()





if __name__=="__main__":
    main()