# coding:utf-8
"""
Name : FigureGenerator.py
Author : thebestwj
Time : 2019/12/13
"""
import numpy as np
import sys

import DataReader
import FileReader
import Painter

# path = "D:\\ZJUfile\\project\\graph\\python\\gfc#000001" # sys.argv[1]
# output_dir = "D:\\ZJUfile\\project\\graph\\python\\img" #sys.argv[2]
# prefix ="123" # sys.argv[3]

path = sys.argv[1]
output_dir = sys.argv[2]
prefix = sys.argv[3]

p = Painter.Painter(output_dir, prefix)
fr = FileReader.FileReader(path)
fr.read()
flag = False

cols = ['toi', 'thi', 'Hb', 'HbO2', 'tHb']
colnames = ['TOI', 'THI', 'ΔCHb', 'ΔCHbO2', 'ΔCtHb']
units = ['%', '', 'umol/L', 'umol/L', 'umol/L']
titles = ['组织血氧饱和度指数',
          '组织血红蛋白浓度指数',
          '脱氧血红蛋白浓度变化',
          '氧合血红蛋白浓度变化',
          '总血红蛋白浓度变化']
results = []
for i in range(4):
    dr = DataReader.DataReader(fr.get(i))
    # print(dr.des())
    for j in range(5):
        unit = units[j]
        col = cols[j]
        colname = colnames[j]
        title = titles[j]
        ymax = dr.max(col)
        ymin = dr.min(col)
        if dr.count(col) == 0:
            # print('no data')
            continue
        flag = True
        y = dr.get(col)

        dict = {'ymin': ymin - (ymax - ymin) / 4,
                'ymax': ymax + (ymax - ymin) / 4,
                'xmin': 0,
                'xmax': y.size * 2,
                'unit': unit,
                'title': title + "(" + colname + ")",
                'filename': col
                }
        dict['xmax'] = y.size * 2
        x = np.arange(0, y.size * 2, 2)
        p.clf()
        p.config(dict)
        p.paint(x, y, col, 'blue')
        results.append(p.save())
    if flag: break
print(";".join(results))
