from base64 import b64encode


def blob2base64(image_data):
    if image_data is None:
        return None
    return b64encode(image_data).decode('ascii')

def bytes2image(bytes):
    print('tentando abrir imagem')

def image2bytes(path_file):
    with open(path_file, 'rb') as imageFile:
        img_byte = imageFile.read()
        print(img_byte)
        return img_byte