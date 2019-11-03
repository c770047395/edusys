package com.bysj.service;

import com.bysj.dao.EvalutionMapper;
import com.bysj.pojo.Evalution;

import java.util.List;

public class EvalutionServiceImpl implements EvalutionService{
    private EvalutionMapper evalutionMapper;

    public void setEvalutionMapper(EvalutionMapper evalutionMapper) {
        this.evalutionMapper = evalutionMapper;
    }

    public Evalution queryEvalutionById(int id) {
        return evalutionMapper.queryEvalutionById(id);
    }

    public List<Evalution> queryEvalutionByTeacherId(int id) {
        return evalutionMapper.queryEvalutionByTeacherId(id);
    }

    public List<Evalution> queryEvalutionByUserId(int id) {
        return evalutionMapper.queryEvalutionByUserId(id);
    }

    public int addEvalution(Evalution evalution) {
        return evalutionMapper.addEvalution(evalution);
    }

    public int updateEvalution(Evalution evalution) {
        return evalutionMapper.updateEvalution(evalution);
    }
}
