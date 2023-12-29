from PIL import Image, ImageDraw, ImageFont
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
    # print(palette)
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
    pink_enemy = Image.new("P", cropping.size)
    pink_enemy.putpalette(global_image.getpalette())
    pink_enemy.paste(cropping, (0, 0))
    pink_enemy.save("images/"+image_name)

def select_blue_enemy():
    global global_image
    image_name = "blue_enemy.png"
    left = 99
    top = 68 + (18 - 1)*2
    right = left + 290
    bottom = top + 18

    cropping = global_image.crop((left, top, right, bottom))
    blue_enemy = Image.new("P", cropping.size)
    blue_enemy.putpalette(global_image.getpalette())
    blue_enemy.paste(cropping, (0, 0))
    blue_enemy.save("images/"+image_name)

def select_yellow_enemy():
    global global_image
    image_name = "yellow_enemy.png"
    left = 99
    top = 68 + (18 - 1)*3
    right = left + 290
    bottom = top + 18

    cropping = global_image.crop((left, top, right, bottom))
    yellow_enemy = Image.new("P", cropping.size)
    yellow_enemy.putpalette(global_image.getpalette())
    yellow_enemy.paste(cropping, (0, 0))
    yellow_enemy.save("images/"+image_name)

def select_enemy_hunted():
    global global_image
    image_name = "enemy_hunted.png"
    left = 99 + 290 - 1
    top = 68
    right = left + 52
    bottom = top + 18

    cropping = global_image.crop((left, top, right, bottom))
    hunted_enemy = Image.new("P", cropping.size)
    hunted_enemy.putpalette(global_image.getpalette())
    hunted_enemy.paste(cropping, (0, 0))
    hunted_enemy.save("images/"+image_name)

def select_enemy_hunt_scores():
    global global_image
    image_name = "enemy_hunted_score.png"
    left = 99 + 290 + 52 - 2
    top = 68
    right = left + 69
    bottom = top + 18

    cropping = global_image.crop((left, top, right, bottom))
    hunted_enemy_score = Image.new("P", cropping.size)
    hunted_enemy_score.putpalette(global_image.getpalette())
    hunted_enemy_score.paste(cropping, (0, 0))
    hunted_enemy_score.save("images/"+image_name)

def select_enemy_eyes():
    global global_image
    image_name = "enemy_eyes.png"
    left = 99 + 290 - 1
    top = 68 + 18 - 1
    right = left + 69
    bottom = top + (18 - 1)*2 + 1

    cropping = global_image.crop((left, top, right, bottom))
    enemy_eyes = Image.new("P", cropping.size)
    enemy_eyes.putpalette(global_image.getpalette())
    enemy_eyes.paste(cropping, (0, 0))
    enemy_eyes.save("images/"+image_name)

def select_snacks():
    global global_image
    image_name = "snacks.png"
    left = 151 - 1
    top = 52 - 1
    right = left + 273
    bottom = top + 18

    cropping = global_image.crop((left, top, right, bottom))
    snacks = Image.new("P", cropping.size)
    snacks.putpalette(global_image.getpalette())
    snacks.paste(cropping, (0, 0))
    snacks.save("images/"+image_name)

def select_powerup():
    global global_image
    image_name = "powerup.png"
    left = 150 + 18 - 1
    top = 52 - 18
    right = left + 18
    bottom = top + 18

    cropping = global_image.crop((left, top, right, bottom))
    tile = create_empty_tile()
    powerup = Image.new("RGB", (tile.width*2 - 1, tile.height))
    powerup.paste(cropping, (0, 0))
    powerup.paste(tile, (cropping.width-1, 0))
    powerup.save("images/"+image_name)

    print(powerup.getpixel((10, 10)))

def create_coin():
    image_name = "coin.png"
    tile = create_empty_tile()

    draw = ImageDraw.Draw(tile)
    inner_square = (7, 7, 10, 10)
    draw.rectangle(inner_square, fill=(255, 184, 174))

    tile.save("images/"+image_name)

def create_empty_tile():
    global global_image
    width, height = 18, 18
    tile = Image.new("RGB", (width, height), COLOR_SEP)

    draw = ImageDraw.Draw(tile)
    inner_square = (1, 1, width - 2, height - 2)
    draw.rectangle(inner_square, fill="black")

    return tile

def create_palette():
    global global_image
    global global_palette
    size = len(global_palette)
    palette = Image.new("RGB", (8*size, 16), color="white")

    font = ImageFont.load_default(size=6)
    draw = ImageDraw.Draw(palette)
    left = 0
    top = 0
    bottom = 8
    for index in range(size):
        color = tuple(global_palette[index])
        right = left + 8
        color_rectangle = (left, top, right, bottom)
        draw.rectangle(color_rectangle, fill=color)
        draw.text((left+1, 10), str(index), fill="black", font=font)
        left = right
    
    palette.save("images/palette.png")

def inline_lil_pac():
    global global_image
    name = "lil_pac_inline.png"
    width = global_image.width
    height = global_image.height
    left, top = 0, 0
    right, bottom = 3*18-3, 18
    rows = []
    for i in range(4):
        if (i == 3):
            right+=1
        row = global_image.crop((left, top, right, bottom))
        rows.append(row)
        top = bottom - 1
        bottom = bottom + 17
    
    inline = Image.new("RGB", (4*width - 3, 18), "black")
    left = 0
    for i in range(4):
        inline.paste(rows[i], (left, 0))
        left = (i+1)*17*3
    
    inline.save("images/" + name)
    



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
    # select_yellow_enemy()
    # select_enemy_hunted()
    # select_enemy_hunt_scores()
    # # select_enemy_eyes()
    # select_snacks()
    # select_powerup()
    # create_palette()
    # create_coin()
    inline_lil_pac()






if __name__=="__main__":
    main()