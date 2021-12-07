<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="order_id" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder="order_id"></el-input>
    </el-form-item>
    <el-form-item label="order_sn" prop="orderSn">
      <el-input v-model="dataForm.orderSn" placeholder="order_sn"></el-input>
    </el-form-item>
    <el-form-item label="fellow_id" prop="fellowId">
      <el-input v-model="dataForm.fellowId" placeholder="fellow_id"></el-input>
    </el-form-item>
    <el-form-item label="fellow姓名" prop="fellowName">
      <el-input v-model="dataForm.fellowName" placeholder="fellow姓名"></el-input>
    </el-form-item>
    <el-form-item label="fellow手机号码" prop="fellowMobile">
      <el-input v-model="dataForm.fellowMobile" placeholder="fellow手机号码"></el-input>
    </el-form-item>
    <el-form-item label="fellow头像" prop="fellowPic">
      <el-input v-model="dataForm.fellowPic" placeholder="fellow头像"></el-input>
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
          orderId: '',
          orderSn: '',
          fellowId: '',
          fellowName: '',
          fellowMobile: '',
          fellowPic: ''
        },
        dataRule: {
          orderId: [
            { required: true, message: 'order_id不能为空', trigger: 'blur' }
          ],
          orderSn: [
            { required: true, message: 'order_sn不能为空', trigger: 'blur' }
          ],
          fellowId: [
            { required: true, message: 'fellow_id不能为空', trigger: 'blur' }
          ],
          fellowName: [
            { required: true, message: 'fellow姓名不能为空', trigger: 'blur' }
          ],
          fellowMobile: [
            { required: true, message: 'fellow手机号码不能为空', trigger: 'blur' }
          ],
          fellowPic: [
            { required: true, message: 'fellow头像不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/order/orderfellow/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderId = data.orderFellow.orderId
                this.dataForm.orderSn = data.orderFellow.orderSn
                this.dataForm.fellowId = data.orderFellow.fellowId
                this.dataForm.fellowName = data.orderFellow.fellowName
                this.dataForm.fellowMobile = data.orderFellow.fellowMobile
                this.dataForm.fellowPic = data.orderFellow.fellowPic
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
              url: this.$http.adornUrl(`/order/orderfellow/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderId': this.dataForm.orderId,
                'orderSn': this.dataForm.orderSn,
                'fellowId': this.dataForm.fellowId,
                'fellowName': this.dataForm.fellowName,
                'fellowMobile': this.dataForm.fellowMobile,
                'fellowPic': this.dataForm.fellowPic
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
