# coding:utf-8
"""
Name : FileReader.py
Author : thebestwj
Time : 2019/12/13
"""
import copy
import pandas as pd
import re


class FileReader:
    def __init__(self, file):
        self.file = file
        self.ch_data = []
        self.data = {
            'toi': [],
            'thi': [],
            'Hb': [],
            'HbO2': [],
            'tHb': [],
        }

    def read(self):
        keys = ['toi', 'thi', 'Hb', 'HbO2', 'tHb']
        data_sample = {
            'toi': [],
            'thi': [],
            'Hb': [],
            'HbO2': [],
            'tHb': [],
        }
        with open(self.file, "rb") as f:
            for line in f:
                line = line.decode('utf-8')
                if re.match('.*:.*', line, 0):
                    col = re.findall('-?\d+\.\d+', line, 0)
                    for _ in range(5):
                        self.data[keys[_]].append(float(col[_]))
                if re.match('.=.', line, 0):
                    df = pd.DataFrame(self.data)
                    self.ch_data.append(df)
                    # 清空数据 下一个通道
                    # print(df.describe())
                    self.data = copy.deepcopy(data_sample)

    def get(self, ch_num):
        # print('get',ch_num)
        return self.ch_data[ch_num]
