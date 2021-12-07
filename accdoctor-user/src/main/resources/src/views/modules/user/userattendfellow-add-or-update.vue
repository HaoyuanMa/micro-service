<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="陪诊员id" prop="fellowId">
      <el-input v-model="dataForm.fellowId" placeholder="陪诊员id"></el-input>
    </el-form-item>
    <el-form-item label="陪诊员name" prop="fellowName">
      <el-input v-model="dataForm.fellowName" placeholder="陪诊员name"></el-input>
    </el-form-item>
    <el-form-item label="陪诊员img" prop="fellowImg">
      <el-input v-model="dataForm.fellowImg" placeholder="陪诊员img"></el-input>
    </el-form-item>
    <el-form-item label="create_time" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="create_time"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          userId: '',
          fellowId: '',
          fellowName: '',
          fellowImg: '',
          createTime: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          fellowId: [
            { required: true, message: '陪诊员id不能为空', trigger: 'blur' }
          ],
          fellowName: [
            { required: true, message: '陪诊员name不能为空', trigger: 'blur' }
          ],
          fellowImg: [
            { required: true, message: '陪诊员img不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: 'create_time不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/user/userattendfellow/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.userAttendFellow.userId
                this.dataForm.fellowId = data.userAttendFellow.fellowId
                this.dataForm.fellowName = data.userAttendFellow.fellowName
                this.dataForm.fellowImg = data.userAttendFellow.fellowImg
                this.dataForm.createTime = data.userAttendFellow.createTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/user/userattendfellow/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'fellowId': this.dataForm.fellowId,
                'fellowName': this.dataForm.fellowName,
                'fellowImg': this.dataForm.fellowImg,
                'createTime': this.dataForm.createTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
