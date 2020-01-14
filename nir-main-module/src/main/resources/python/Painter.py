# coding:utf-8
"""
Name : Painter.py
Author : the_best_wj
Time : 2019/12/10
"""
import matplotlib.pyplot as plt
import numpy as np


class Painter:
    def __init__(self,output_path,prefix):
        # 中文字体
        # zh_font = fm.FontProperties(f_name="C:/Windows/fonts/simsun.ttc")

        # 中文字体
        # plt.rcParams['font.family'] = ['sans-serif']
        # plt.rcParams['font.sans-serif'] = ['simsun']
        self.dict = {'ymin': 0,
                     'ymax': 100,
                     'xmin': 0,
                     'xmax': 100,
                     'title': 'title',
                     'unit':'unit',
                     'filename':'filename'}
        if output_path[-1] != '\\':
            output_path = output_path + '\\'
        self.output_path = output_path
        self.prefix = prefix

    def config(self, config):
        self.dict = config

    def paint(self, x, y, label, color):

        # 判断数据格式
        try:
            assert (isinstance(x, np.ndarray))
            assert (isinstance(y, np.ndarray))
            assert (x.shape == y.shape)
        except AssertionError:
            return 'wrong data'

        # 绘图
        # 修正符号没有
        plt.title(self.dict['title'] + "的波形", fontproperties='Simsun',fontsize =30,fontweight='bold')
        plt.xlabel("时间", fontproperties='Simsun',fontsize = 30)
        plt.ylabel(self.dict['unit'] , fontproperties='Simsun',fontsize = 30)


        plt.ylim(ymin=self.dict['ymin'], ymax=self.dict['ymax'])
        plt.xlim(xmin=self.dict['xmin'], xmax=self.dict['xmax'])
        plt.plot(x, y, color=color, label=label)
        ax = plt.gca()
        ax.tick_params(axis='both', labelsize=30)

        # plt.legend(loc='upper left',fontsize = 20)
        plt.grid(linestyle='-')

    def save(self):
        """保存图像 返回图像路径
        """
        # 设置图片大小
        fig = plt.gcf()
        fig.set_size_inches(35, 9)

        file_name = self.prefix + self.dict['filename']
        plt.savefig(self.output_path + file_name)
        return self.output_path + file_name + '.png'

    def clf(self):
        """清除所绘图像"""
        plt.clf()
